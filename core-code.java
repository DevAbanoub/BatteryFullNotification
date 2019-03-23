package com.abanoubhanna.battery;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void checkBatteryState(View sender) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = registerReceiver(null, filter);
        
        //the real check goes here
        int chargeState = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        String battState;

        switch (chargeState) {
            case BatteryManager.BATTERY_STATUS_CHARGING:
                battState = "charging";
                break;
            case BatteryManager.BATTERY_STATUS_FULL:
                battState = "charged. Disconnect the Charger";
                break;
            default:
                battState = "not charging";
        }
   
        //use it as a Notification instead of just showing a text in textview
        
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(strState);
    }
}
