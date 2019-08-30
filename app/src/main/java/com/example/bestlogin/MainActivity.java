package com.example.bestlogin;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.transitionseverywhere.TransitionManager;

public class MainActivity extends AppCompatActivity {

    ImageView acvUser;
    ImageView acvUserIcon;

    ImageView acvEmail;
    ImageView acvEmailIcon;

    ImageView acvPassword;
    ImageView acvPasswordIcon;

    TextInputLayout tilMain;
    TextInputEditText tietMain;
    ImageView acvMainButon;

    ViewGroup transitionsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setNewListeners();
    }

    private void bindViews() {
        acvUser = findViewById(R.id.acvUser);
        acvUserIcon = findViewById(R.id.acvUserIcon);

        acvEmail = findViewById(R.id.acvEmail);
        acvEmailIcon = findViewById(R.id.acvEmailIcon);

        acvPassword = findViewById(R.id.acvPassword);
        acvPasswordIcon = findViewById(R.id.acvPasswordIcon);

        tilMain = findViewById(R.id.tilMain);
        tietMain = findViewById(R.id.tietMain);
        acvMainButon = findViewById(R.id.acvMainButon);

        transitionsContainer = findViewById(R.id.transitions_container);
    }

    private void setNewListeners() {
        /*acvUserButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acvUserIcon.animate().alpha(0).setDuration(1000).start();
                acvUser.animate().alpha(0).setDuration(1000).start();
                acvUserIcon.animate().rotation(360).setDuration(1000).start();
                acvUserIcon.animate().translationX(360).setDuration(1000).start();
                acvUser.animate().translationX(360).setDuration(1000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        layoutUser.setVisibility(View.GONE);
                    }
                }).start();
                tilEmail.animate().alpha(1).setDuration(500).setStartDelay(500).start();
                tietUser.animate().alpha(0).setDuration(750).start();
                tilUser.animate().alpha(0).setDuration(750).start();
            }
        });

        acvEmailButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acvEmailIcon.animate().alpha(0).setDuration(1000).start();
                acvEmail.animate().alpha(0).setDuration(1000).start();
                acvEmailIcon.animate().rotation(360).setDuration(1000).start();
                acvEmailIcon.animate().translationX(360).setDuration(1000).start();
                acvEmail.animate().translationX(360).setDuration(1000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        layoutEmail.setVisibility(View.GONE);
                    }
                }).start();
                tilPassword.animate().alpha(1).setDuration(500).setStartDelay(500).start();
                tietEmail.animate().alpha(0).setDuration(750).start();
                tilEmail.animate().alpha(0).setDuration(750).start();
            }
        });

        acvPasswordButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acvPasswordIcon.animate().alpha(0).setDuration(1000).start();
                acvPassword.animate().alpha(0).setDuration(1000).start();
                acvPasswordIcon.animate().rotation(360).setDuration(1000).start();
                acvPasswordIcon.animate().translationX(360).setDuration(1000).start();
                acvPassword.animate().translationX(360).setDuration(1000).start();
                tietPassword.animate().alpha(0).setDuration(750).start();
                tilPassword.animate().alpha(0).setDuration(750).start();
            }
        });*/
    }

    private void setListeners() {
        /*acvUserButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ObjectAnimator valueAnimator = ObjectAnimator.ofFloat(acvUserIcon, "rotation",
                        visibleUser?0f:360f, visibleUser?360f:0f);
                valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnimator.setDuration(600);
                valueAnimator.start();

                TransitionManager.beginDelayedTransition(transitionsContainer);
                visibleUser = !visibleUser;
                tilUser.setVisibility(visibleUser ? View.VISIBLE : View.GONE);

                isRotated = !isRotated;
                acvUserIcon.setRotation(isRotated ? 45 : 0);
            }
        });

        acvEmailButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 270f);
                ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(270f, 360f);
                ValueAnimator valueAnimator3 = ValueAnimator.ofInt(!visibleEmail?110:200, 0);
                ValueAnimator valueAnimator4 = ValueAnimator.ofInt(0, !visibleEmail?200:110);

                valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnimator.setDuration(750);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float progress = (float) animation.getAnimatedValue();
                        acvEmailIcon.setRotationX(progress);
                    }
                });
                valueAnimator.start();

                valueAnimator3.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnimator3.setDuration(500);
                valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int progress = (int) animation.getAnimatedValue();
                        tietEmail.setMinWidth(progress);
                        tietEmail.getLayoutParams().width = progress;
                        tilEmail.getLayoutParams().width = progress;
                        tietEmail.requestLayout();
                        tilEmail.requestLayout();
                    }
                });
                valueAnimator3.start();

                tilEmail.animate().alpha(0f).setDuration(500).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        visibleEmail = !visibleEmail;
                        tilEmail.setHint(visibleEmail?"Password":"Email");
                        acvEmailIcon.setBackground(getDrawable(visibleEmail?R.drawable.ic_lock_24dp:R.drawable.ic_mail_24dp));
                    }
                }).start();

                valueAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnimator2.setDuration(250);
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float progress = (float) animation.getAnimatedValue();
                        acvEmailIcon.setRotationX(progress);
                    }
                });
                valueAnimator2.setStartDelay(750);
                valueAnimator2.start();

                valueAnimator4.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnimator4.setDuration(500);
                valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int progress = (int) animation.getAnimatedValue();
                        tietEmail.setMinWidth(progress);
                        tietEmail.getLayoutParams().width = progress;
                        tilEmail.getLayoutParams().width = progress;
                        tietEmail.requestLayout();
                        tilEmail.requestLayout();
                    }
                });
                valueAnimator4.setStartDelay(500);
                valueAnimator4.start();

                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(tilEmail, "alpha", 1f).setDuration(500);
                objectAnimator2.setStartDelay(500);
                objectAnimator2.start();

            }
        });

        acvPasswordButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acvPasswordIcon.animate().rotation(visiblePassword?360:0).setDuration(1000).start();
                acvPasswordIcon.animate().translationX(visiblePassword?360:0).setDuration(1000).start();
                acvPassword.animate().translationX(visiblePassword?360:0).setDuration(1000).start();
                tietPassword.animate().alpha(visiblePassword?0:1).setDuration(750).start();
                tilPassword.animate().alpha(visiblePassword?0:1).setDuration(750).start();
                visiblePassword = !visiblePassword;
            }
        });*/

    }

}
