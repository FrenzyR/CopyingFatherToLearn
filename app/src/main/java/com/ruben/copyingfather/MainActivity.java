package com.ruben.copyingfather;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ruben.copyingfather.data.SimpsonAdapter;
import com.ruben.copyingfather.databinding.ActivityMainBinding;

public class  MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> launcher;
    private ActivityResultCallback<ActivityResult> activityResult;
    private ActivityResultContracts.StartActivityForResult contract;
    private SimpsonAdapter simpsonCharacterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.launcher = this.registerForActivityResult(this.contract, this.activityResult);
        simpsonCharacterAdapter.setLauncher(launcher);
        RecyclerView recyclerView = binding.recyclerViewId;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(this.simpsonCharacterAdapter);
    }

}