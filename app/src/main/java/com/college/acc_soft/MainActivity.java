package com.college.acc_soft;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static com.college.acc_soft.Notification.Constants.TOPIC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.college.acc_soft.Activities.Login_Activity;
import com.college.acc_soft.Fragments.AcademicsFragment;
import com.college.acc_soft.Fragments.Admin_PanelFragment;
import com.college.acc_soft.Fragments.EnrichmentFragment;
import com.college.acc_soft.Fragments.General_InfoFragment;
import com.college.acc_soft.Fragments.LibraryFragment;
import com.college.acc_soft.Fragments.Nav_Drawer_Fragment;
import com.college.acc_soft.Fragments.Pay_Fee_OnlineFragment;
import com.college.acc_soft.Fragments.PlacementFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity implements Nav_Drawer_Fragment.FragmentDrawerListner{

    ImageView icon;
    Nav_Drawer_Fragment drawerFragment;
    DrawerLayout drawerLayout;
    FirebaseAuth auth;
    FirebaseUser currentUser;
    int cas = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        icon = findViewById(R.id.menu_btn);
        drawerLayout = findViewById(R.id.drawer_layout);
        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();



        if(currentUser == null){

            auth.signInAnonymously();
        }

        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Subscribed";
                        if (!task.isSuccessful()) {
                            msg = "Subscribe failed";
                        }
                        Log.d(TAG, msg);
                        Toast.makeText(MainActivity.this,msg, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(MainActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        drawerFragment = (Nav_Drawer_Fragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        assert drawerFragment != null;
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
        drawerFragment.setDrawerListener(MainActivity.this);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputMethodManager inputManager = (InputMethodManager) MainActivity.this
                            .getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(
                            MainActivity.this.getCurrentFocus()
                                    .getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                } catch (Exception e) {

                }
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_framelayout, new General_InfoFragment());
        cas = 0;
        transaction.commit();

    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_framelayout, fragment);
        if(cas == 0){
            transaction.addToBackStack(null);
            cas = 1;
        }
        transaction.commit();
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    public void displayView(int position) {

        switch (position) {

            case 0:
                Toast.makeText(this, "General Information", Toast.LENGTH_SHORT).show();
                loadFragment(new General_InfoFragment());
                break;


            case 1:
                Toast.makeText(this, "Fees Information", Toast.LENGTH_SHORT).show();
                loadFragment(new Pay_Fee_OnlineFragment());
                break;

            case 2:
                Toast.makeText(this, "Academics", Toast.LENGTH_SHORT).show();
                loadFragment(new AcademicsFragment());
                break;

            case 3:
                Toast.makeText(this, "Library", Toast.LENGTH_SHORT).show();
                loadFragment(new LibraryFragment());
                break;

            case 4:
                Toast.makeText(this, "Placements", Toast.LENGTH_SHORT).show();
                loadFragment(new PlacementFragment());
                break;

            case 5:
                Toast.makeText(this, "Acknowledgement", Toast.LENGTH_SHORT).show();
                loadFragment(new EnrichmentFragment());
                break;

            case 6:
                Toast.makeText(this, "Admin Panel", Toast.LENGTH_SHORT).show();
                loadFragment(new Admin_PanelFragment());
                break;


            case 7:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Login_Activity.class);
                startActivity(intent);
                auth.signOut();
                finish();


            default:
                break;
        }

    }
}