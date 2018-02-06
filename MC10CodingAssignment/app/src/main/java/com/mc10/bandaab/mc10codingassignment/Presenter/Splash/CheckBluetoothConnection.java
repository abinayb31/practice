package com.mc10.bandaab.mc10codingassignment.Presenter.Splash;

import android.bluetooth.BluetoothAdapter;
import android.util.Log;

/**
 * Created by bandaab on 1/16/18.
 */

public class CheckBluetoothConnection implements IBluetoothValidator {

    @Override
    public void checkBluetooth(ICheckBluetoothConnectionListener bluetoothConnectionListener) {
        Log.d("abinay","checkBluetooth");
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            bluetoothConnectionListener.OnNOBluetooth();
        } else {
            if (!mBluetoothAdapter.isEnabled()) {
                bluetoothConnectionListener.OnBluetoothNotConnected();
            } else {
                bluetoothConnectionListener.OnBluetoothConnected();
            }
        }
    }
}
