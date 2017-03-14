package org.apache.cordova;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;

public class APPAplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		//搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
		//TbsDownloader.needDownload(getApplicationContext(), false);
		
		QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
			
			@Override
			public void onViewInitFinished(boolean arg0) {
				// TODO Auto-generated method stub
				Log.e("app", " onViewInitFinished is " + arg0);
			}
			
			@Override
			public void onCoreInitFinished() {
				// TODO Auto-generated method stub
				
			}
		};
		QbSdk.setTbsListener(new TbsListener() {
	            @Override
	            public void onDownloadFinish(int i) {
	                Log.d("app","onDownloadFinish is " + i);
	            }

	            @Override
	            public void onInstallFinish(int i) {
	                Log.d("app","onInstallFinish is " + i);
	            }

	            @Override
	            public void onDownloadProgress(int i) {
	                Log.d("app","onDownloadProgress:"+i);
	            }
	        });
		
		QbSdk.initX5Environment(getApplicationContext(),  cb);
	}

}
