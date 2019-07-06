package com.example.foodly.foodly.Meal;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.foodly.foodly.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMealDesc extends Fragment {

    String mealDescritpion;
    TextView mealDescription;
    public FragmentMealDesc(String mealDescritpion) {
        this.mealDescritpion = mealDescritpion;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_meal_desc, container, false);
   mealDescription=view.findViewById(R.id.mealDescription);
   mealDescription.setMovementMethod(new ScrollingMovementMethod());

        mealDescritpion="حريق كاد ان يقتل طفل في حلب\n" +
                "\n" +
                "حدث اليوم مساءً حريق بمنزل في حي \" مساكن السبيل \" وقد علم رجال الاطفاء من صاحب المنزل ان ابنه ( ماهر رشواني البالغ من العمر 6 سنوات ) متواجد داخل المنزل و اثناء اخماد الحريق الذي التهم معظم المنزل وجد الطفل ماهر مربط بجنزير ( كلبش ) و هو فاقد الوعي يبدو وانه قد تعرض للعقاب من اهله ، وقد قام رجال الاطفاء على الفور بفك وثاقه و اسعافه للمشفى وهو الآن بحالة مستقرة .\n" +
                "\n" +
                "وبحسب ما اوضح والد الطفل لفوج الاطفاء انه كان معاقب بسبب مشاكسته ورميه للاغراض على الارض وعدم استجابته لوالده .\n" +
                "\n" +
                "وعن الحريق فسببه ماس كهربائي حدث بالانفرتر\n" +
                "\n" +
                "وقد قام فوج الاطفاء بكتابة تقريرهم وتحويل الموضوع للجهات الأمنية التي تقوم بالتحقيقات اللازمة\n" +
                "\n" +
                "وقد ازر وساند فوج الاطفال رجال شرطة قسم العزيزية الذين ضربو طوقاً امنياً حول المنزل بسبب وجود بعض الفضوليين الذين حاولو ان يعيقو عمل رجال الاطفاء ";

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("تفاصيل الوجبة");
        mealDescription=view.findViewById(R.id.mealDescription);
        mealDescription.setText(mealDescritpion);
    }
}
