package shan.splan;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import shan.splan.databinding.ActivitySelfAssessmentBinding;
import shan.splan.model.Question;
import shan.splan.utils.ToolBarUtil;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class SelfAssessmentActivity extends AppCompatActivity {

    private ActivitySelfAssessmentBinding binding;
    private static List<Question> questions;
    private String[] q = {"１．所有的事都由伴侶一方決定，較少有討論的餘地"
            , "２．我必須向伴侶交代所有的花費、認識的朋友或行蹤"
            , "３．我的伴侶認為我應該以他的需求為優先，處處配合他、迎合他"
            , "４．我的伴侶很難溝通，讓我情緒不穩定或覺得厭煩"
            , "５．我覺得已經無法再忍受伴侶的某些行為或表現"
            , "６．伴侶會說我醜、肥、低能、無用或沒人要等"
            , "７．我們會為了穿著、工作、交友、金錢、孩子、家事、彼此的父母等事情吵架"
            , "８．伴侶喝酒或吸毒是我們衝突的原因"
            , "９．當我們衝突時，有一方會威脅要破壞東西、傷害自己、傷害對方或對方的家人"
            , "１０．我們有一方會出手、推或打傷對方"
            , "１１．我們有一方會在對方極度不願意的情況下仍勉強進行性行為"
            , "１２．我的伴侶會以金錢、孩子或其他方式來控制我"};
    private int number;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_self_assessment);
        ToolBarUtil.initDefaultBackToolbar(this, binding.toolBar);
        number = getIntent().getIntExtra("question_number", -1);
        boolean first = getIntent().getBooleanExtra("first", false);
        if (number < 0) {
            return;
        }
        if (first) {
            if (questions != null) {
                questions = null;
            }
            questions = new ArrayList<>();
            for (String s : q) {
                questions.add(new Question(s));
            }
        }
        binding.question.setText(questions.get(number).getQuestion());
        binding.progressText.setText(String.format("%1$s/%2$s", number, questions.size()));
        binding.progressBar.setProgress(number);
        binding.yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions.size() > number) {
                    Question question = questions.get(number);
                    question.setComplete(true);
                    question.setAnswer(true);
                    binding.no.setAlpha(0.3f);
                    binding.yes.setAlpha(1.0f);
                }
                goNextActivity();
            }
        });

        binding.no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questions.size() > number) {
                    Question question = questions.get(number);
                    question.setComplete(true);
                    question.setAnswer(false);
                    binding.no.setAlpha(1.0f);
                    binding.yes.setAlpha(0.3f);
                }
                goNextActivity();
            }
        });
    }

    private void goNextActivity() {
        if (questions.size() == number + 1) {
            questions = null;
            Intent intent = new Intent(this, FinishSelfAssessmentActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, SelfAssessmentActivity.class);
            intent.putExtra("question_number", number + 1);
            startActivity(intent);
        }
    }
}
