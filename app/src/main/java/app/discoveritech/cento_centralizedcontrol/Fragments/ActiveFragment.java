package app.discoveritech.cento_centralizedcontrol.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;

import app.discoveritech.cento_centralizedcontrol.Activities.DashboardActivity;
import app.discoveritech.cento_centralizedcontrol.Adapter.DevicesAdapter;
import app.discoveritech.cento_centralizedcontrol.GeneralClasses.Global;
import app.discoveritech.cento_centralizedcontrol.Model.Devices;
import app.discoveritech.cento_centralizedcontrol.R;

public class ActiveFragment extends Fragment {

    RecyclerView devices_recycler;
    DevicesAdapter devicesAdapter;
    ArrayList<Devices> devicesList = new ArrayList<>();
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_active, container, false);
        Global.device_back_tag = "ActiveFragment";
        DashboardActivity.add_friend.setVisibility(View.GONE);
        DashboardActivity.txt_mainToolbar.setText("Active Devices");
        init();
        return v;
    }

    private void init() {
        devicesList.clear();
        Global.devicesList.clear();
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "ON", "", "Bedroom - 1", "cento-001", "Connected"));
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "ON", "", "TV Lounge", "cento-003", "Connected"));
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "ON", "", "Drawing Room", "cento-005", "Connected"));
        Global.devicesList.add(new Devices("Fan", "" + new Date(), "OFF", "", "Kitchen", "cento-006", "Connected"));
        Global.devicesList.add(new Devices("Bulb", "" + new Date(), "ON", "", "Kitchen", "cento-007", "Connected"));
        Global.devicesList.add(new Devices("Fridge", "" + new Date(), "ON", "", "Kitchen", "cento-008", "Connected"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Locked", "", "Main Gate", "cento-009", "Connected"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Unlocked", "", "Roof Gate", "cento-011", "Connected"));
        Global.devicesList.add(new Devices("Gate Lock", "" + new Date(), "Unlocked", "", "Bedroom - 1 Gate", "cento-013", "Connected"));

        devicesList.addAll(Global.devicesList);

        devices_recycler = v.findViewById(R.id.active_recycler);
        devicesAdapter = new DevicesAdapter(devicesList, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        devices_recycler.setLayoutManager(mLayoutManager);
        devices_recycler.setItemAnimator(new DefaultItemAnimator());
        devices_recycler.setAdapter(devicesAdapter);
        devicesAdapter.notifyDataSetChanged();
    }
}