package it.skinjobs.responsive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import it.skinjobs.responsive.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        NavController controller = Navigation.findNavController(this, R.id.navigation_controller_fragment);
        BottomNavigationView bottomNavigationView = binding.contentMain.bottomNavigationView;
        if (bottomNavigationView != null) {
            appBarConfiguration = new AppBarConfiguration.Builder
                    (R.id.nav_tab1, R.id.nav_tab2, R.id.nav_tab3).build();
            NavigationUI.setupActionBarWithNavController(this, controller, appBarConfiguration);
            NavigationUI.setupWithNavController(bottomNavigationView, controller);
        }
        NavigationView navigationView = binding.navMenuView;
        if (navigationView != null) {
            appBarConfiguration = new AppBarConfiguration.Builder
                    (R.id.nav_tab1, R.id.nav_tab2, R.id.nav_tab3)
                    .setOpenableLayout(binding.drawerLayout)
                    .build();
            NavigationUI.setupActionBarWithNavController(this, controller, appBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, controller);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        NavigationView navView = findViewById(R.id.nav_menu_view);
        return result;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.navigation_controller_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}