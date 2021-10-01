package com.sabin.sastofurniture;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/sabin/sastofurniture/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnlogin", "Landroid/widget/Button;", "emails", "Landroid/widget/EditText;", "passwords", "permissions", "", "", "[Ljava/lang/String;", "signup", "Landroid/widget/TextView;", "checkRunTimePermission", "", "hasPermission", "", "login", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "requestPermission", "validation", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private final java.lang.String[] permissions = {"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION"};
    private android.widget.EditText emails;
    private android.widget.EditText passwords;
    private android.widget.TextView signup;
    private android.widget.Button btnlogin;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkRunTimePermission() {
    }
    
    private final boolean hasPermission() {
        return false;
    }
    
    private final void requestPermission() {
    }
    
    public final void login() {
    }
    
    private final boolean validation() {
        return false;
    }
    
    public LoginActivity() {
        super();
    }
}