package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project.dao.UserDao;

public class DashboardFragment extends Fragment {
    private MainViewModel mainViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView dashboardTitleView = view.findViewById(R.id.textView);
        Bundle args = getArguments();
        DashboardFragmentArgs dashboardFragmentArgs = null;
        if (args != null) {
            dashboardFragmentArgs = DashboardFragmentArgs.fromBundle(args);
        }

        if (dashboardFragmentArgs != null) {
            dashboardTitleView.setText(dashboardFragmentArgs.getDashboardTitle());
        }


        final NavController controller3 = Navigation.findNavController(view);
        view.findViewById(R.id.button3).setOnClickListener(button3 -> {
            controller3
                    .navigate(DashboardFragmentDirections.actionDashboardFragmentToMonitoringFragment());

        });





        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        final TextView vendor = view.findViewById(R.id.vendor);
        final TextView name = view.findViewById(R.id.name);
        final TextView version = view.findViewById(R.id.version);
        final TextView resolution = view.findViewById(R.id.resolution);
        final TextView maxrange  = view.findViewById(R.id.maxrange);
        final TextView power = view.findViewById(R.id.power);
        final TextView xyz = view.findViewById(R.id.xyz);
        view.findViewById(R.id.buttonON).setOnClickListener(v -> {
            mainViewModel.accelerationLiveData.observe(getViewLifecycleOwner(), (accelerationInformation) -> {
                vendor.setText("Vendor " + accelerationInformation.getSensor().getVendor());
                name.setText("Name " + accelerationInformation.getSensor().getName());
                version.setText("Version " + accelerationInformation.getSensor().getVersion());
                resolution.setText("Resolution " + accelerationInformation.getSensor().getResolution());
                maxrange.setText("MaxRange " + accelerationInformation.getSensor().getMaximumRange());
                power.setText("Power " + accelerationInformation.getSensor().getPower());
                xyz.setText("X: " + accelerationInformation.getX() + " Y: " + accelerationInformation.getY() + " Z: " + accelerationInformation.getZ());

            });
        });
        view.findViewById(R.id.buttonOFF).setOnClickListener(v -> {
            mainViewModel.accelerationLiveData.removeObservers(getViewLifecycleOwner());
                });


    }
    private class PrimeRunnable implements Runnable {

        @Override
        public void run() {

        }
    }

}
