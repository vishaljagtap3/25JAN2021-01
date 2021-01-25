package in.bitcode.imageviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView mImgCity;
    private Button mBtnPrev, mBtnNext;
    private int[] mArrImageIds = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4, R.drawable.img5, R.drawable.img6,
            R.drawable.img7, R.drawable.img8
    };
    private int mCurrentIndex = 0;

    private Button mBtnAddImage, mBtnRemoveImage;

    private LinearLayout mMainContainer;

    private ArrayList<ImageView> mListImageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mImgCity = findViewById(R.id.imgCity);
        mBtnPrev = findViewById(R.id.btnPrev);
        mBtnNext = findViewById(R.id.btnNext);

        mBtnPrev.setOnClickListener(new BtnPrevClickListener());
        mBtnNext.setOnClickListener(new BtnNextClickListener());

        mBtnAddImage = findViewById(R.id.btnAddImage);
        mBtnRemoveImage = findViewById(R.id.btnRemoveImage);
        mBtnAddImage.setOnClickListener(new BtnAddImageClickListener());
        mBtnRemoveImage.setOnClickListener(new BtnRemoveImageClickListener());

        mMainContainer = findViewById(R.id.mainContainer);

        mListImageViews = new ArrayList<ImageView>();
    }

    class BtnAddImageClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            ImageView imgNew = new ImageView(MainActivity.this);
            imgNew.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
            imgNew.setImageResource(R.drawable.img5);

            mMainContainer.addView(imgNew);

            mListImageViews.add(imgNew);

        }
    }

    class BtnRemoveImageClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //mMainContainer.removeViewAt(0);

            if( mListImageViews.size() > 0) {
                mMainContainer.removeView(mListImageViews.get(0));
                mListImageViews.remove(0);
            }
            else {
                Toast.makeText(MainActivity.this, "No views to remove...", Toast.LENGTH_LONG).show();
            }
        }
    }


    class BtnPrevClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (mCurrentIndex > 0) {
                mCurrentIndex--;
                mImgCity.setImageResource(mArrImageIds[mCurrentIndex]);
            } else {
                Toast.makeText(
                        MainActivity.this,
                        "No Previous Image...",
                        Toast.LENGTH_LONG
                ).show();
            }
        }
    }

    class BtnNextClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (mCurrentIndex < mArrImageIds.length - 1) {
                mCurrentIndex++;
                mImgCity.setImageResource(mArrImageIds[mCurrentIndex]);
            } else {
                Toast.makeText(
                        MainActivity.this,
                        "No Next Image...",
                        Toast.LENGTH_LONG
                ).show();
            }
        }
    }


}