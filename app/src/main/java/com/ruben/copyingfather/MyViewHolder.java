package com.ruben.copyingfather;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ruben.copyingfather.data.SimpsonCharacter;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private final View element;
    private TextView name;

    private TextView year;

    ImageView logo;

    private SimpsonCharacter simpsonCharacter;
    private AppCompatActivity containerActivity;
    private ActivityResultLauncher<Intent> launcher;
    public MyViewHolder(View element) {
        super(element);
        this.element = element;
        this.name = element.findViewById(R.id.textViewNombre);
        this.year = element.findViewById(R.id.textViewYear);
        this.logo = element.findViewById(R.id.imageView);

        element.setOnClickListener(this.onElementClick);
    }

    private final View.OnClickListener onElementClick = view -> {
        Intent intent = new Intent(containerActivity, MainActivity2.class);

        launcher.launch(intent);
        containerActivity.startActivity(intent);
    };

    public TextView getName() {
        return name;
    }

    public TextView getYear() {
        return year;
    }

    public ImageView getLogo() {
        return logo;
    }

    public void setSimpsonCharacter(SimpsonCharacter simpsonCharacter) {
        this.simpsonCharacter = simpsonCharacter;
    }

    public void setContainerActivity(AppCompatActivity containerActivity) {
        this.containerActivity = containerActivity;
    }

    public void setLauncher(ActivityResultLauncher<Intent> launcher) {
        this.launcher = launcher;
    }
}
