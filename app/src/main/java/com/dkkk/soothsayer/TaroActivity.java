package com.dkkk.soothsayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;
import android.os.Handler;
import android.widget.ImageButton;


import androidx.appcompat.app.AppCompatActivity;


public class TaroActivity extends AppCompatActivity {

    private final int[] imageArray = {
            R.drawable.rasklad1,
            R.drawable.rasklad2,
            R.drawable.rasklad3,
            R.drawable.rasklad4,
            R.drawable.rasklad5
    };
    private final String[] textArray = {
            "В жизни бывают времена когда кажется, что ничего не происходит. Вы должны научиться непредвзято смотреть на мир и на себя, видеть то, что есть, а не то, что хотели или надеялись увидеть. Вы обязаны пойти на личную жертву. Если Вы выдержите, жертва окупится.",
            "Вы достигли главного, конечного успеха в Ваших устремлениях. Вы способны управлять жизнью с пользой для других, если удастся заставить их слушать.Возможно, у Вас не хватит сил управлять ими, но Вы можете избежать их власти над Вами.",
            "Вы имеете власть управлять окружающим миром.Сейчас пришло время, когда успех и понимание Вам гарантированы. Вы способны бороться и готовы умереть за людей и имущество, но нужно понимать, стоит ли умирать за то, что защищаешь.",
            "Эта карта олицетворяет человека, имеющего власть продвинуть или сокрушить Вас. Все, чего Вы достигли, рухнуло. Разовьете ли Вы потенциал управлять окружающим миром или разменяете на демонстрацию суетной власти?",
            "Перед Вами испытание на выносливость. Не поддавайтесь отчаянию. Перед Вами выбор величайшей важности для Вас и Вашего будущего. Вы уже нашли путь, используйте Вашу власть мудро, оставайтесь в спокойной уверенности."
    };
    private final int[] imageArray2 = {
            R.drawable.loovers,
            R.drawable.death,
            R.drawable.wheel,
            R.drawable.star,
            R.drawable.sun,
            R.drawable.hermit
    };
    private final String[] textArray2 = {
            "Влюбленные призывают Вас исследовать и примирить противоположности в Вас самих, а не пытаться удалить или изменить их. Понимая и примиряя обе стороны своей натуры, Вы станете единым целым, не конфликтующим с собой.",
            "Большая перемена вот-вот случится в Вашей жизни. Хорошая или плохая, но ее не избежать. Заметьте, что эта карта, хотя и символизирует позитивную трансформацию в духовном усовершенствовании, при гадании очень неблагоприятна.",
            "Есть в жизни вещи, на которые никто не может повлиять. Вы должны ознавать, что Колесо постоянно вращается и Ваша жизнь зависит от него.Если Вы хотите добиться успеха, придется бороться, чтобы овладеть неподвластным.",
            "В этой точке Вашего путешествия Вы становитесь учителем, равно как и искателем. Звезды располагаются в Вашем направлении, давая Вам власть: быть в центре Вселенной, чтобы изменять небеса по собственной воле.",
            "Сейчас Вы можете ясно видеть свой путь. То, над чем Вы работали так напряженно, готово принести плоды. Не анализируйте их, не подвергайте сомнению, пытаясь понять их действительный смысл.",
            "Если эта карта олицетворяет гадающего, то Вам предстоит период самопознания. Это время, когда следует заново оценить свою жизнь, связи и цели. Возможные изменения, которые произойдут в жизни."
    };
    private ImageView generationImage1;
    private TextView imageDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taro);

        Button situation = findViewById(R.id.situation);
        Button day = findViewById(R.id.day);
        ImageButton resetButton = findViewById(R.id.resetButton);
        final ImageView imageViewSituation = findViewById(R.id.sms3);
        final ImageView imageSituation2 = findViewById(R.id.imageSituation2);
        final ImageView imageSituation3 = findViewById(R.id.Situation3);


        resetButton.setOnClickListener(v -> {

            situation.setVisibility(View.VISIBLE);
            day.setVisibility(View.VISIBLE);
            imageViewSituation.setVisibility(View.GONE);
            imageSituation3.setVisibility(View.GONE);
            imageSituation2.setVisibility(View.GONE);
            generationImage1.setVisibility(View.GONE);
            imageDescription.setVisibility(View.GONE);
        });

        situation.setOnClickListener(v -> {
            situation.setVisibility(View.GONE);
            day.setVisibility(View.GONE);
            imageSituation2.setVisibility(View.VISIBLE);
            imageSituation2.setImageResource(R.drawable.otvet1);
            new Handler().postDelayed(() -> {
                imageViewSituation.setVisibility(View.VISIBLE);
                imageViewSituation.setImageResource(R.drawable.sms3);
            }, 1000);
            Random random = new Random();
            int randomIndex = random.nextInt(imageArray.length);
            new Handler().postDelayed(() -> {
                generationImage1.setImageResource(imageArray[randomIndex]);
                generationImage1.setVisibility(View.VISIBLE);
                imageDescription.setText(textArray[randomIndex]);
                imageDescription.setVisibility(View.VISIBLE);
            }, 2500);
        });
        day.setOnClickListener(v -> {
            situation.setVisibility(View.GONE);
            day.setVisibility(View.GONE);
            imageSituation3.setVisibility(View.VISIBLE);
            imageSituation3.setImageResource(R.drawable.otvet2);
            new Handler().postDelayed(() -> {
                imageViewSituation.setVisibility(View.VISIBLE);
                imageViewSituation.setImageResource(R.drawable.sms3);
            }, 1000);
            Random random = new Random();
            int randomIndex = random.nextInt(imageArray2.length);
            new Handler().postDelayed(() -> {
                generationImage1.setImageResource(imageArray2[randomIndex]);
                generationImage1.setVisibility(View.VISIBLE);
                imageDescription.setText(textArray2[randomIndex]);
                imageDescription.setVisibility(View.VISIBLE);
            }, 2500);
        });
        generationImage1 = findViewById(R.id.generationImage1);
        imageDescription = findViewById(R.id.imageDescription);
    }
    public void GoBack(View v){
        Intent intent = new Intent(this, Homeactivity.class);
            startActivity(intent);
    }

}


