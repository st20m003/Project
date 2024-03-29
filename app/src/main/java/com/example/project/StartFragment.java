package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class StartFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_startfragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final NavController controller = Navigation.findNavController(view);
        view.findViewById(R.id.button1).setOnClickListener(button1 -> {
            controller
                    .navigate(StartFragmentDirections.actionStartFragmentToDashboardFragment("Zur Datenaufzeichnung <START> drücken\nZum Anhalten <STOP> drücken\nZum Löschen <DELETE DATA> drücken\nZur Datenübersicht <GO TO MONITORING> drücken" ));
        });
        view.findViewById(R.id.button4).setOnClickListener(button4 -> {
            controller
                    .navigate(StartFragmentDirections.actionStartFragmentToMonitoringFragment());

        });
    }
}
