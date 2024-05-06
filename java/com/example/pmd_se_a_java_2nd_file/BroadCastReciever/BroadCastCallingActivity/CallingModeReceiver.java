package com.example.pmd_se_a_java_2nd_file.BroadCastReciever.BroadCastCallingActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class CallingModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        telephony.listen(new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                switch (state) {
                    case TelephonyManager.CALL_STATE_RINGING:
                        // Broadcast that a call is received
                        Intent callIntent = new Intent("com.example.pmd_se_a_java_2nd_file.CALL_RECEIVED");
                        callIntent.putExtra("incoming_number", incomingNumber);
                        context.sendBroadcast(callIntent);
                        break;
                    case TelephonyManager.CALL_STATE_IDLE:
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        // Do nothing or handle as needed
                        break;
                }
            }
        }, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
