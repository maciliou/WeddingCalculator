Release key hash:
w6vvT6WP1wf+LnBBmh+nOLB3NVw=

Brandon's debug key hash 
bYWYpwIv5yvT/wufUCN10kyMKdY=

Put the code to get the debug hash in onCreate()
    // Add code to print out the key hash
    try {
        PackageInfo info = getPackageManager().getPackageInfo(
                "com.facebook.samples.hellofacebook", 
                PackageManager.GET_SIGNATURES);
        for (Signature signature : info.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
    } catch (NameNotFoundException e) {

    } catch (NoSuchAlgorithmException e) {

    }
	
