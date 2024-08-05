package com.example.tracuutt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * {@inheritDoc}
     * <p>
     * Perform initialization of all fragments.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button submitButton  = findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitButtonClick(v);
            }
        });
    }
    public void onSubmitButtonClick(View view)
    {
        // Lấy thông tin từ các thành phần giao diện
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextID = findViewById(R.id.editTextID);
        RadioGroup radioGroupEducation = findViewById(R.id.radioGroupEducation);
        RadioButton radioButtonUniversity = findViewById(R.id.radioButtonUniversity);
        RadioButton radioButtonCollege = findViewById(R.id.radioButtonCollege);
        CheckBox checkBoxFootball = findViewById(R.id.checkBoxFootball);
        CheckBox checkBoxBasketball = findViewById(R.id.checkBoxBasketball);
        CheckBox checkBoxVolleyball = findViewById(R.id.checkBoxVolleyball);
        EditText editTextAdditionalInfo = findViewById(R.id.editTextAdditionalInfo);

        // Kiểm tra điều kiện
        if (editTextName.getText().toString().isEmpty() || editTextName.getText().toString().length() < 3) {
            Toast.makeText(this, "Tên không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        if (editTextID.getText().toString().isEmpty() || editTextID.getText().toString().length() != 9) {
            Toast.makeText(this, "Chứng minh nhân dân không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!radioButtonUniversity.isChecked() && !radioButtonCollege.isChecked()) {
            Toast.makeText(this, "Chưa chọn bằng cấp", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!checkBoxFootball.isChecked() && !checkBoxBasketball.isChecked() && !checkBoxVolleyball.isChecked()) {
            Toast.makeText(this, "Chưa chọn sở thích", Toast.LENGTH_SHORT).show();
            return;
        }

        // Hiển thị thông tin
        String info = "Tên: " + editTextName.getText().toString() + "\n";
        info += "Chứng minh nhân dân: " + editTextID.getText().toString() + "\n";

        if (radioButtonUniversity.isChecked()) {
            info += "Bằng cấp: Đại học\n";
        } else {
            info += "Bằng cấp: Cao đẳng\n";
        }

        info += "Sở thích: ";
        if (checkBoxFootball.isChecked()) {
            info += "Bóng đá, ";
        }
        if (checkBoxBasketball.isChecked()) {
            info += "Bóng rổ, ";
        }
        if (checkBoxVolleyball.isChecked()) {
            info += "Đá cầu, ";
        }

        info = info.substring(0, info.length() - 2); // Loại bỏ dấu phẩy và khoảng trắng cuối cùng
        info += "\nThông tin bổ sung: " + editTextAdditionalInfo.getText().toString();

        // Hiển thị thông tin trong Toast hoặc có thể làm gì đó khác với thông tin này
        Toast.makeText(this, info, Toast.LENGTH_LONG).show();
    }
}