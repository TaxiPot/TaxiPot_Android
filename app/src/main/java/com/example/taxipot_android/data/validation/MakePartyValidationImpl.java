package com.example.taxipot_android.data.validation;

import android.location.Address;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.MakePartyRepository;
import com.example.taxipot_android.util.MapPosition;

import java.io.IOException;
import java.util.Date;

import io.reactivex.Single;

public class MakePartyValidationImpl implements MakePartyValidation {
    private MakePartyRepository repository;
    private MapPosition position;

    public MakePartyValidationImpl(MakePartyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<TaxiPot> makeTaxiPot(TaxiPot taxiPot) {
        String errorMessege = null;
        User user = repository.getUserInfo();

        if(taxiPot.getStart().equals("")) {
            errorMessege = "출발지를 입력해주세요.";
        } else if(taxiPot.getFinish().equals("")) {
            errorMessege = "도착지를 입력해주세요.";
        } else if (!(taxiPot.isGenderMan() || taxiPot.isGenderWoman())) {
            errorMessege = "입장 가능한 성별을 선택해주세요.";
        } else if (taxiPot.getStartAge() > taxiPot.getEndAge()) {
            errorMessege = "입장 가능한 나이 입력이 잘못되었어요.";
        } else if (taxiPot.getDepartTime() <= new Date().getTime()) {
            errorMessege = "지정한 출발시간이 이미 지났어요 ㅠㅠ";
        } else if(taxiPot.getStartAge() > user.getAge() || taxiPot.getEndAge() < user.getAge()) {
            errorMessege = "연령대를 회원님의 연령이 포함되게 설정해 주세요.";
        }
        if(taxiPot.isOnlySameGender()) {
            if(user.getIsMan()) {
                taxiPot.setGenderWoman(false);
            } else {
                taxiPot.setGenderMan(false);
            }
        }
        if(errorMessege!=null) return Single.error(new Exception(errorMessege));

        try {
            Address start = repository.getLocateCoordinate(taxiPot.getStart());
            taxiPot.setStartLatitude(start.getLatitude());
            taxiPot.setStartLongtitude(start.getLongitude());
            Address finish = repository.getLocateCoordinate(taxiPot.getFinish());
            taxiPot.setEndLatitude(finish.getLatitude());
            taxiPot.setEndLongtitude(finish.getLongitude());
        } catch (IOException e) {
            return Single.error(e);
        }
        return repository.makeTaxiPot(taxiPot);
    }
}
