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
    private MainViewModel.AccelerationLiveData accelerationLiveData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        TextView dashboardTitleView = view.findViewById(R.id.textView);
        Bundle args = getArguments();
        DashboardFragmentArgs dashboardFragmentArgs = null;
        if (args != null) {
            dashboardFragmentArgs = DashboardFragmentArgs.fromBundle(args);
        }

        if (dashboardFragmentArgs != null) {
            dashboardTitleView.setText(dashboardFragmentArgs.getDashboardTitle());
        }





        //mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        final TextView vendor = view.findViewById(R.id.vendor);
        final TextView name = view.findViewById(R.id.name);
        final TextView version = view.findViewById(R.id.version);
        final TextView resolution = view.findViewById(R.id.resolution);
        final TextView maxrange = view.findViewById(R.id.maxrange);
        final TextView power = view.findViewById(R.id.power);
        final TextView xyz = view.findViewById(R.id.xyz);


        view.findViewById(R.id.buttonON).setOnClickListener(v -> {

            accelerationLiveData = (MainViewModel.AccelerationLiveData) mainViewModel.accelerationInsert();

            accelerationLiveData.onActive();
            accelerationLiveData.observe(getViewLifecycleOwner(), (accelerationInformation) -> {
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
            accelerationLiveData.onInactive();
            //mainViewModel.accelerationLiveData.removeObservers(getViewLifecycleOwner());
        });

        view.findViewById(R.id.buttonDelete).setOnClickListener(v -> {
            accelerationLiveData.delete();
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final NavController controller = Navigation.findNavController(view);
        view.findViewById(R.id.buttonMonitoring).setOnClickListener(button -> {
            controller
                    .navigate(DashboardFragmentDirections.actionDashboardFragmentToMonitoringFragment());

        });
    }
}


