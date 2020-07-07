package com.example.jpnetmvp.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.jpnetmvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PlaceDialogFragment extends DialogFragment {
    @BindView(R.id.tvplace)
    TextView tvplace;
    @BindView(R.id.btnJapan)
    Button btnJapan;
    @BindView(R.id.btnVietNam)
    Button btnVietNam;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.dialog_place, null);
        ButterKnife.bind(getActivity(),view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnJapan = view.findViewById(R.id.btnJapan);
        btnVietNam = view.findViewById(R.id.btnVietNam);

        btnJapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
        btnVietNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}
