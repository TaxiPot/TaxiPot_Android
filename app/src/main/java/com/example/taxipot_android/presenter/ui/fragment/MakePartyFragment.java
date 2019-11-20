package com.example.taxipot_android.presenter.ui.fragment;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taxipot_android.R;
import com.example.taxipot_android.databinding.FragmentMakePartyBinding;
import com.example.taxipot_android.presenter.ui.BaseFragment;
import com.example.taxipot_android.presenter.viewModel.MakePartyViewModel;
import com.example.taxipot_android.presenter.viewModelFactory.MakePartyViewModelFactory;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

public class MakePartyFragment extends BaseFragment<FragmentMakePartyBinding> {

    @Inject
    MakePartyViewModelFactory factory;
    MakePartyViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setFragmentLayout(R.layout.fragment_make_party);
        View v = super.onCreateView(inflater, container, savedInstanceState);
        viewModel = ViewModelProviders.of(this, factory).get(MakePartyViewModel.class);
        binding.setFragment(this);
        binding.setVm(viewModel);
        viewModel.getToast().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                makeToast(s);
            }
        });
        viewModel.onlySameGender.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Log.e(this.getClass().getSimpleName(),aBoolean.toString());
            }
        });
        return v;
    }

    public void applySeatSelect(View v) {
        NavHostFragment.findNavController(this).navigate(R.id.action_makePartyFragment_to_makePartySeatFragment);
    }
}
