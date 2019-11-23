package com.example.taxipot_android.data.validation;

import com.example.taxipot_android.domain.entity.TaxiPot;
import com.example.taxipot_android.domain.repository.MakePartySeatRepository;

import io.reactivex.Single;

public class MakePartySeatValidationImpl implements MakePartySeatValidation {
    private MakePartySeatRepository repository;

    public MakePartySeatValidationImpl(MakePartySeatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<TaxiPot> joinToTaxiPot(int seat_num) {
        if(seat_num<0 || seat_num>3) return Single.error(new Exception("좌석을 선택해주세요."));
        else {
            int roomId = repository.getTaxiPot().getRoomid();
            String userId = repository.getUser().getUserId();
            return repository.joinToTaxiPot(roomId,userId,seat_num);
        }
    }

    @Override
    public TaxiPot getTaxiPot() {
        return repository.getTaxiPot();
    }
}
