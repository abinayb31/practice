package com.mc10.bandaab.mc10codingassignment.Presenter.Splash;

/**
 * Created by bandaab on 1/16/18.
 */

public interface ICheckBluetoothConnectionListener {
    void OnBluetoothConnected();
    void OnBluetoothNotConnected();
    void OnNOBluetooth();
}
