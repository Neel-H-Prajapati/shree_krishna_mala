package com.example.shreerammala;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
 private ImageButton button;
 private TextView textview,geeta;
 private TextView text2;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private int counter = 0;
    int counter1=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

button=findViewById(R.id.butt);
textview=findViewById(R.id.textView2);
text2=findViewById(R.id.textView3);
geeta=findViewById(R.id.textView6);
        mediaPlayer = MediaPlayer.create(this, R.raw.krishna);
        mediaPlayer.setOnCompletionListener(mp -> isPlaying = false);
       geeta.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this,geeta.class);
               startActivity(intent);
           }
       });
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if (mediaPlayer != null) {
            if(!isPlaying) {
                isPlaying=true;
                mediaPlayer.start(); // Play the sound
                counter++;
                textview.setText("જય શ્રી કૃષ્ણ :" + String.valueOf(counter));
            }
        }


        if(counter==108)
        {
            counter=0;
            counter1++;
            text2.setText("માળા નંબર :"+String.valueOf(counter1));
        }
    }
});
    }
    protected void onDestroy() {
        super.onDestroy();
        // Release MediaPlayer resources
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}