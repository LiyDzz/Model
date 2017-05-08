package com.example.lenovo.day02okhttppicter;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ListView;

import com.jiyun.adapter.MyAdapter;
import com.jiyun.thread.ThreadUtils;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class MainActivity extends Activity {
    private ListView listView;
    private List<String> urls;
    private PtrFrameLayout ptrFrameLayout;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        ptrFrameLayout = (PtrFrameLayout) findViewById(R.id.ptrFragmelayout);
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(this);
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(this);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.setFooterView(footer);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.addPtrUIHandler(footer);

        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                Log.e("Mainctivity", "开始加载更多");
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        SystemClock.sleep(2000);
                        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410128290&di=064321b268ca1be50a829c79739d7d05&imgtype=0&src=http%3A%2F%2Fpic17.nipic.com%2F20111021%2F8289149_105725398120_2.jpg");
                        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410128289&di=1b50325b95b467d7ad028fac6591a072&imgtype=0&src=http%3A%2F%2Fwww.zhlzw.com%2FUploadFiles%2FArticle_UploadFiles%2F201204%2F20120412123929822.jpg");
                        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410128289&di=20303b4b6939a0d9be2f3ac59d5de447&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F60%2F97%2F48Q58PIC92r_1024.jpg");
                        ThreadUtils.runOnMainThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                                ptrFrameLayout.refreshComplete();
                            }
                        });
                    }
                }.start();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                Log.e("MainActivity", "开始下拉刷新");

            }
        });


        listView = (ListView) findViewById(R.id.listview);
        adapter = new MyAdapter(urls);
        listView.setAdapter(adapter);

//        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//                boolean mIsBottom = true;
//                if (scrollState == SCROLL_STATE_IDLE && mIsBottom) {
//                    mCurPage++;
//                    initData();
//                }
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//
//            }
//        });
    }

    private void initData() {
        urls = new ArrayList<>();
//        urls.add("http://192.168.1.132:8080/aa.jpg");
//        urls.add("http://192.168.1.132:8080/bb.jpg");
//        urls.add("http://192.168.1.132:8080/cc.jpg");
//        urls.add("http://192.168.1.132:8080/dd.jpg");
//        urls.add("http://192.168.1.132:8080/ee.jpg");
//        urls.add("http://192.168.1.132:8080/ty.jpg");
        urls.add("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491409838691&di=1ae0e48964f0b8dbdf40c6736bc243a1&imgtype=0&src=http%3A%2F%2Fimage.3761.com%2Fnvxing%2F2016022921%2F2016022921382152113.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410128292&di=a8bf7d4d7a800dc1dbad5ed00af6d6da&imgtype=0&src=http%3A%2F%2Fpic.yesky.com%2FuploadImages%2F2016%2F336%2F33%2F69VN0ZT5JG5G.JPG");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410215028&di=fb414b00ba9bb0e756902402da29ae27&imgtype=0&src=http%3A%2F%2Fwww.zhlzw.com%2FUploadFiles%2FArticle_UploadFiles%2F201204%2F20120412123914329.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410128292&di=8764a9be0feac628e2d19d19e9373d5f&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F15%2F36%2F00%2F73b58PICgvY_1024.jpg");
        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410128290&di=3991947e621eb56cbd43925c802871ec&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F59%2F88%2F47v58PICab5_1024.jpg");

        //    urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410128288&di=865799a75b3195d0d28d8bae4c593fd8&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F14%2F15%2F80%2F67n58PICT4r_1024.jpg");
        //    urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410128288&di=b8735f92b112349e3cbbddd5fb12a551&imgtype=0&src=http%3A%2F%2Fimg.taopic.com%2Fuploads%2Fallimg%2F140804%2F240388-140P40P33417.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410128287&di=7eaf6216e4aded686a8d69db01a8bc4b&imgtype=0&src=http%3A%2F%2Fimage.3761.com%2Fnvxing%2F2016022921%2F2016022921382452125.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410128286&di=335a6eda5c683a568bebfe80b2018678&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F15%2F24%2F50%2F43Q58PICkj4_1024.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410128284&di=ee7385a0a3d0923d86bdd217815ebbab&imgtype=0&src=http%3A%2F%2Fpic31.nipic.com%2F20130802%2F13339859_165056273128_2.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410491531&di=25374d1801938dcd968d0167cb821ee4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3D2a29d40709b30f2435cfe407fda5fd75%2F8cb1cb13495409238cf41c189458d109b3de4932.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410491530&di=51dbbd695fe5bedd84d8fd984e88dca0&imgtype=0&src=http%3A%2F%2Fimg06.tooopen.com%2Fimages%2F20161101%2Ftooopen_sy_184342137412.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410491530&di=39d09117c7ddad9c0dd4dc7a480ecd15&imgtype=0&src=http%3A%2F%2Fzyn-chem.com%2Farticle%2Fpic%2FTP10961_04.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410491530&di=57ef83858a62bd535d13ef22da9236f3&imgtype=0&src=http%3A%2F%2Fpic19.nipic.com%2F20120309%2F7448627_091258562168_2.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410491529&di=0ec56932c636d20a347133b0ec02ea6d&imgtype=0&src=http%3A%2F%2Fimg2.3lian.com%2F2014%2Ff2%2F159%2Fd%2F37.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410564731&di=b21f860352d34c4a6f0d12f0a7ddf960&imgtype=0&src=http%3A%2F%2Fhomemade.keliren.cn%2Ftuku%2Fa%2F20160823%2F57bbc98d52a34.jpg_600.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410564731&di=097ddd26be56660cccf43ed063016e23&imgtype=0&src=http%3A%2F%2Fimg.warting.com%2Fallimg%2F2015%2F1019%2F1t4da0rdxn1.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410564731&di=f5959548392a7cd522b07c24df75f76f&imgtype=0&src=http%3A%2F%2Fp0.qhimg.com%2Ft01d583d2a98ad67be9.png");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410564730&di=61f9adf9a6bf1fa8601c78c34f780609&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F142%2Fd%2F69.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410564730&di=428c5472bdb52a045bb9b05c5d93a25c&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F91%2Fd%2F48.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410643403&di=10d09520516be94b09de4453704b7827&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fw2%2F10%2Fd%2F63.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410643403&di=87adf9d53c13214e4a04c27392982116&imgtype=0&src=http%3A%2F%2Fpic4.nipic.com%2F20091121%2F3764872_215617048242_2.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410643402&di=c87259e1d88b3f4f23fe762f2c6dd1d6&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F14%2F27%2F45%2F71r58PICmDM_1024.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410643402&di=5467eb34ed251850ef8874a0909dc594&imgtype=0&src=http%3A%2F%2Fimgtu.5011.net%2Fuploads%2Fcontent%2F20170213%2F4508141486970240.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410735250&di=6dce59809c026f3c11a1427b0ad968cc&imgtype=0&src=http%3A%2F%2Fimg04.penfan.com%2Fuploads%2Fjoke%2F20161219%2F14821349805683.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410735250&di=fe97aaf59e1bab9176bbbf9800da83aa&imgtype=0&src=http%3A%2F%2Fdown.laifudao.com%2Ftupian%2F20117418112.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410735248&di=b2299fc60d0fbf86f0ffa4ef96fff415&imgtype=0&src=http%3A%2F%2Fww1.sinaimg.cn%2Flarge%2Fbca0b9cfjw1dzbw1juu4dj.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491411278854&di=f1dac843cfb9be7bdec289a8e3c98077&imgtype=0&src=http%3A%2F%2Fimg.photo.163.com%2FJCxMCRSEcQoWOOEMxaUvDg%3D%3D%2F148900262680547967.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410735248&di=534e3e740c9fb6fa68973a8906ca2e65&imgtype=0&src=http%3A%2F%2Fs1.sinaimg.cn%2Fmiddle%2F506cc9abt7a716c03f0a0%26690");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491411171773&di=b1fcff066d1b2327f3452ef18f624b25&imgtype=0&src=http%3A%2F%2Fimg17.poco.cn%2Fmypoco%2Fmyphoto%2F20151219%2F02%2F174412049201512190225282426888668357_001.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410735248&di=69c7d3dfeaa3d05086f2fca9acd0093d&imgtype=0&src=http%3A%2F%2Fdown.laifudao.com%2Ftupian%2F20135316458.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491411171775&di=64a25e1b34d9ad55248df9f0c25f7280&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20160625%2F13188467932448e390ae8e6dd0c24d91_th.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410735247&di=bf49442915ab8ec9fc95f0401fb03f95&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201601%2F19%2F20160119223842_4HTJh.thumb.700_0.jpeg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491411171778&di=9cbdcf71b603e7d3ba34089c5f762553&imgtype=0&src=http%3A%2F%2Fs9.sinaimg.cn%2Forignal%2F4b634e6751196f7735fb8");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410890223&di=18e2221768cf9befd0a893797ed885fb&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2012%2F0417%2F35%2F3.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491411171780&di=96c4d959e76bb3ecbe30f6d15c051f8f&imgtype=0&src=http%3A%2F%2Fimg4.wikia.nocookie.net%2F__cb20101003133149%2Fhongkongbus%2Fzh%2Fimages%2F9%2F94%2FADS_HA8721_234A_TWWS.JPG");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410890218&di=02d16256d6cff406772c14dd39afedeb&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F19%2F97%2F73%2F10658PICwik_1024.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410215027&di=80e87c46dbade3301506ed706013cc4f&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F96%2F73%2F63H58PICzwQ_1024.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410890218&di=8743e0a9bc46c67727b9b353c7434a54&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F12%2F24%2F21E58PICfx8_1024.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1492005893&di=31342577853cda63ee1afcb339797143&imgtype=jpg&er=1&src=http%3A%2F%2Fcdn0.hbimg.cn%2Fstore%2Fsnsthumbs%2F650_2000%2Falbum%2F200927%2F8F79DABFE4AD9BB187F1C9CF44AC89F0CA872BF6F1.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410890215&di=17799bcf9c4b81537f2acef47a88dfc9&imgtype=0&src=http%3A%2F%2Fcdnq.duitang.com%2Fuploads%2Fitem%2F201505%2F07%2F20150507223632_SvAuT.jpeg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491411075746&di=69a91fe668906a1e7539b60f42f725ba&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%253D580%2Fsign%3Daf86cf0db2b7d0a27bc90495fbee760d%2Ff11f3a292df5e0fe9b972abe5c6034a85fdf7285.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410986970&di=de46ab2fb81848d2a7607fdae9807218&imgtype=0&src=http%3A%2F%2Fdl.bizhi.sogou.com%2Fimages%2F1680x1050%2F2014%2F04%2F24%2F590270.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491411075748&di=73f29734bbbd4e3812ef0dcf4902f5b1&imgtype=0&src=http%3A%2F%2Fi1.hdslb.com%2Fbfs%2Farchive%2F657ae980fed1251612a8ccb35bd71f982c07f966.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410986970&di=f66ff86bed19396656c245b045896ff8&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Ff%2F546b12b859f58.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491411075748&di=3d8aa884c01a6dfc92208b374371c010&imgtype=0&src=http%3A%2F%2Fwanzao2.b0.upaiyun.com%2Fsystem%2Fpictures%2F31361406%2Foriginal%2F1449929409_500x500.png");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410986970&di=7b3cb3e946833069adcae53297663bde&imgtype=0&src=http%3A%2F%2Fh5.86.cc%2Fwalls%2F20150415%2F1024x768_87818e06276841b.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491411075748&di=1703276a4a8e27703bc8ea8a341971a4&imgtype=0&src=http%3A%2F%2Fwanzao2.b0.upaiyun.com%2Fsystem%2Fpictures%2F27749433%2Foriginal%2F1440033922_650x809.png");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410986970&di=9687be2e1d5db617e0937dfd81276667&imgtype=0&src=http%3A%2F%2Fdl.bizhi.sogou.com%2Fimages%2F2013%2F11%2F29%2F425177.jpg");
//        urls.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491410986969&di=f93305bb8bc6b0ec36c3bf137c84f929&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fa%2F57a0131036064.jpg");
    }

}
