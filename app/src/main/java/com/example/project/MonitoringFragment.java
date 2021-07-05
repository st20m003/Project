package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MonitoringFragment extends Fragment {
    private Application application;
    private MuFDatabase muFDatabase;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monitoringfragment, container, false);
        //TextView data = view.findViewById(R.id.data);
        //data.(application.getDatabase().getUserDao().getAllData());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final NavController controller2 = Navigation.findNavController(view);
        view.findViewById(R.id.button2).setOnClickListener(button2 -> {
            controller2
                    .navigate(MonitoringFragmentDirections.actionMonitoringFragmentToStartFragment());

        });

    }
}
