package ir.puyaars.plantsapp.repository.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import ir.puyaars.plantsapp.repository.entities.PlantEntity;
import ir.puyaars.plantsapp.repository.entities.Spec;

public class SampleData {

    public static List<PlantEntity> getSampleData() {
        List<PlantEntity> entities = new ArrayList<>();

        List<Spec> specs1 = new ArrayList<>();
        specs1.add(new Spec("نور","نزدیک پنجچره یا نور غیر مستقیم نیم سایه نیم آفتاب نور دلخواه این گیاه است . مواظب اشعه مستقیم آفتاب باشید"));
        specs1.add(new Spec("دما","اگرچه تا 10 درجه سانتی گراد مقاومت دارد ولی کمتر از 13 درجه را دوست ندارد . در تابستان تا حدئد 30 درحه مقاومت می کند . ولی در درجات بالاتر غبارپاشی مداوم لازم است"));
        specs1.add(new Spec("آبیاری","آبیاری زیاده از اندازه برای این گیاه مضر و سطح خاک در فاصله دو آبیاری باید خشک شود . در تابستان هفته ای یکبار و در زمستان هر دو هفته یکبار احتیاج به آبیاری دارد . همیشه قبل از آبیاری رطوبت سطح خاک را بازدید کنید"));
        specs1.add(new Spec("رطوبت","در تابستان هفته ای دو تا سه بار و در زمستان هر هفته یکبار نیاز به غبارپاشی دارد. از آب ولرم و سبک فاقد املاح جهت غبارپاشی استفاده کنید"));
        specs1.add(new Spec("تغذیه","نیاز چندانی به تغذیه مصنوعی نیست و تغذیه بیش از اندازه باعث تجمع املاح در خاک می شوند در صورت نیاز هر ماه یکبار تغذیه مصنوعی کنید"));
        specs1.add(new Spec("خاک مناسب","خاک سبک لیمویی بهترین و مناسب ترین محیط برای رشد ریشه این گیاه است"));
        specs1.add(new Spec("تعویض گلدان","هر سال در فصل بهار با شروع فصل رشد احتیاج به تعویض گلدان دارد و در سالهای بعد با سنگین شدن گلدان تعویض خاک سطح گلدان با خاک نو و غنی پیشنهاد می گردد"));
        specs1.add(new Spec("تمیز کردن برگ ها","برگ ها را با احتیاط با پارچه یا اسفنج مرطوب تمیز کنید"));
        specs1.add(new Spec("ازدیاد","گرفتن قلمه در بهار . هر قلمه سه گره داشته باشد و در دمای 23 درجه ریشه دار گردد. ریشه های هوایی برگ انجیری را هرگز قطع نکنید بلکه با نصب قیم خزدار آنها را وادار به فرو رفتن در خزه مرطوب کنید."));
//        specs1.add(new Spec("",""));

        PlantEntity plant1 = new PlantEntity.Builder()
                .withName("برگ انجیری")
                .withNameRoot("اژبن( اژ=مار +  بن = ریشه) ( اشاره به ریشه های مار مانند آن است)")
                .withEnName("Swiss cheese plant")
                .withSiName("Monstera deliciosa")
                .withCommonName("برگ انجیری")
//                .withImage("")
                .withFamily("Aracea")
                .withIdentity("چندگونه از فیلودندرون با برگ های پهن و بریدگی های عمیق در گلفروشی ها موجود است که همه آنها تحت نام برگ انجیری به فروش می رسند ولی در گیاه شناسی که اساس طبقه بندی روی گل و دستگاه زایشی است ممکن است دو گیاه ظاهرا مشابه دو نام مختلف را به خود اختصاص دهند . ددر هر صورت آن گیاه با هر نامی که عرضه گردد در این نیازها مشترکتند.\n" +
                        "هوای گرم و مرطوب ایده آل آنهاست . تغییرات درجه حرارت را به راحتی می پذیرند ، ریشه های هوایی آنها احتیاج به تغذیه و تکیه گاه خزه دار دارند ، برای افراد مبتدی گیاهانی مناسب هستند")
                .withHerbals(
                        "نوک برگ ها قهوا ای رنگ می شوند: گیاه تشنه است ، فورا آبیاری کنید . همیشه خاک سطح گلدان را بازدید کنید به خصوص در تابستان که نیاز به آب بیشتری است.\n" +
                        "برگ ها رنگ پریده و سطح زیرین آنها  داری تار عنکبوت است : \n" +
                        "عامل آن کنه ریز قرمز است . گیاه را با سم کنه کش طبق دستور هر دو هفته یکبار سمپاشی کنید تا علایم برطرف گردند . غبارپاشی بخصوص زیر سطح برگ ها در کاهش آفت موثر است.\n" +
                        "برگ های زیرین زرد رنگ و سپس قهوه ای می گردند که شدت آن در زمستان بیشتر است:\n" +
                        "آبیاری بیش از اندازه عامل ان است . اجازه دهید سطح خاک گلدان در فاصله بین دو آبیاری کاملا خشک شود سپس آبیاری را با مفدار کمتری انجام دهید . هر دو هفته یکبار آبیاری کافی است.زهکش را بازدید کنید.\n" +
                        "رشد گیاه متوقف است : نور کافی نیست ، گلدان را به محل پر نور تری ممنتقل کنید.\n" +
                        "برگ ها بد شکل و شکافدار می شوند: گیاه را از محل پر تردد خارج کنید صدمات فیزیکی عامل آن است .\n" +
                        "لکه های سیاه و زخم مانند روی برگ هاست : هوا سرد است گیاه را به محل گرمتری منتقل کنید.\n" +
                        "بعضی از برگ ها شکاف طبیعی هم ندارند: گیاه از گونه دیگری است و عدم شکاف عمیق در برگ ها کاملا طبیعی است.\n" +
                        "لکه های قهوه ای در وسط یا حاشیه برگ ها نمایان شده است:\n" +
                        "در آفتاب غبارپاشی کرده اید . عبور نور از قطرات آفتاب به جای مانده روی برگ ها مانند عبور از شیشه است که به برگ ها صدمه وارد می آورد ، در سایه غبارپاشی کنید . برگ های صدمه دیده را بلا کارد تیز تا انتها قطع کنید .\n" +
                        "برگ ها رنگ پریده اند:\n" +
                        "احتیاج به تغذیه مصنوعی دارد. گیاه از کمبود عناصر در خاک رنج می برد هر سه هفته یکبار طبق دستور با کود مخصوص گیاه را تغذیه کنید.\n" +
                        "زخم های سفید پنبه ای شکل روی برگ ها مشاهده کی گردد :\n" +
                        "عامل آن حشره آفت است ، با سم حشره کش نفوذی هردو هفته یکبار گیاه را سم پاشی کنید.تا علایم برطرف گردد.\n" +
                        "برگ ها خشک و چروک دار هستند:\n" +
                        "گیاه تشنه و هوا خشک است .فورا آبیاری کنید .هر هفته دو یا سه بار غبارپاشی کنید.\n")
                .withSpecs(specs1)
                .withFavourite(true)
                .build();


        List<Spec> specs2 = new ArrayList<>();
        specs2.add(new Spec("نور",":به نور فراوان احتیاج دارد . اگرچه کمی نیم سایه را قبول می کند اما گیاه در آن ضعیف تر است . قلمه ها در نیم نور نیم سایه بهتر ریشه می دهند"));
        specs2.add(new Spec("دما","دمای بالاتر از 21 درجه نیازمند است .قلمه ها را باید گرم نگه داشت"));
        specs2.add(new Spec("آبیاری","آب در جریان را بهتر از آب انبار شده می پسندد . بین دو آبیاری کمی خاک را خشک کنید"));
        specs2.add(new Spec("رطوبت","نیاز به غبارپاشی ندارد"));
        specs2.add(new Spec("خاک","قلمه ها باید در ماسه شکری ، ماشی یا کمپوست بدون خاک کاشت گردند . گیاه بالغ احتیاج به خاک لوم دارد"));

        PlantEntity plant2 = new PlantEntity.Builder()
                .withName("شمعدانی")
//                .withNameRoot("")
                .withEnName("Geranium")
                .withSiName("pelargonium")
                .withCommonName("شمعدانی")
                .withFamily("Geraniaceae")
//                .withImage("")
                .withIdentity("گیاهی  ملی است که همواره با گل لاله عباسی قبل از اینکه گل های دیگر وارد ایران شوند مورد نگهداری بوده است . آرایش این گل در لبه حوض خانه های قدیمی مشهور و خاطره انگیز است . این گیاه علاوه بر حوض خانه های قدیمی مشهور و خاطره انگیز است . امکان کاشت در باغچه ها در گلدان و در محیط های بسته نیز قابل نگهداری است . ازدیاد آن بسیار ساده و با قلمه صورت می گیرد ، واریته های بذری پر گل هم اکنون در ایران موجود است و در ایام عید و بهار به فروش می رشند")
//                .withHerbals("")
                .withSpecs(specs2)
                .withFavourite(false)
                .build();

        entities.add(plant1);
        entities.add(plant2);

        return entities;
    }

    /**
     *
     * in case you want to load data from assets folder
     *
     * @param context for getting assets folder
     * @param fileName name of the asset file
     * @return a list of plants
     *
     *
     */
    public static List<PlantEntity> loadAssetPlants(Context context,String fileName) {
        String json = null;
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Type plantType = new TypeToken<List<PlantEntity>>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(json,plantType);
    }

}
