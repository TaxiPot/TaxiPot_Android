package com.example.taxipot_android.data.api;

import io.reactivex.Observable;
import retrofit2.http.PATCH;

public interface TaxipotApi {
    @PATCH
    Observable<Void> joinToTaxipot();
}
