package com.example.project10_1;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 조사");

        btnResult = findViewById(R.id.btnResult);

        int[] voteCount = new int[9];
        Arrays.fill(voteCount, 0);

        int[] imageId = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        String[] imgName = {
                "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매",
                "피아노 레슨", "피아노 앞의 소녀들", "해변에서"
        };
        ImageView[] image = new ImageView[9];

        for (int i = 0; i < image.length; i++) {
            int index = i;
            image[index] = findViewById(imageId[i]);
            image[index].setOnClickListener(view -> {
                voteCount[index]++;
                Toast.makeText(MainActivity.this, imgName[index] + " : " + voteCount[index] + " 표를 선택", Toast.LENGTH_SHORT).show();
            });
        }

        btnResult.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("VoteCount", voteCount);
            intent.putExtra("ImageName", imgName);

            //startActivity(intent);

            mStartForResult.launch(intent);
        });
    }

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == RESULT_OK) {
            Log.i("TAG", "RESULT OK : " + RESULT_OK);

            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.custom_dialog);

            Intent intent = result.getData();

            TextView dialogTv = dialog.findViewById(R.id.dialogtv);
            ImageView dialogIv = dialog.findViewById(R.id.dialogiv);

            dialogTv.setText(intent.getStringExtra("ImageName"));
            dialogIv.setImageResource(intent.getIntExtra("ImageId", 0));

            Button btnFinish = dialog.findViewById(R.id.buttonFinish);
            btnFinish.setOnClickListener(view -> dialog.dismiss());

            dialog.setCancelable(false);
            dialog.show();
        }
    });
}