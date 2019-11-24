package com.example.taxipot_android.data.validation;

import com.example.taxipot_android.domain.entity.Bug;
import com.example.taxipot_android.domain.entity.User;
import com.example.taxipot_android.domain.repository.SettingRepository;

import io.reactivex.Single;

public class SettingValidationImpl implements SettingValidation {

    private SettingRepository repository;

    public SettingValidationImpl(SettingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Single<Bug> postBug(String content) {
        if(content.equals("")) {
            return Single.error(new Exception("버그 내용을 입력해주세요."));
        } else {
            return repository.postBug(content);
        }
    }

    @Override
    public Single<User> changePW(String fromPW, String toPW) {
        if(fromPW.equals("") || toPW.equals("")) {
            return Single.error(new Exception("변경 전 비밀번호와 변경할 비밀번호를 모두 입력해주세요."));
        } else {
            return repository.changePW(fromPW,toPW);
        }
    }
}
