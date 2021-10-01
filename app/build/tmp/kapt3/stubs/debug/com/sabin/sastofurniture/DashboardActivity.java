package com.sabin.sastofurniture;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020*H\u0014J\b\u00101\u001a\u00020*H\u0014J\b\u00102\u001a\u00020*H\u0002J\b\u00103\u001a\u00020*H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0018\u00010&R\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/sabin/sastofurniture/DashboardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "accelerometerEventListener", "Landroid/hardware/SensorEventListener;", "acclValue", "", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "field", "", "frameLayout", "Landroid/widget/FrameLayout;", "gyroEventListener", "lastAcclValue", "navigationView", "Lcom/google/android/material/navigation/NavigationView;", "powerManager", "Landroid/os/PowerManager;", "preferences", "Lcom/sabin/sastofurniture/Preferences;", "previousMenuItem", "Landroid/view/MenuItem;", "proximityEventListener", "sensorAccelerometer", "Landroid/hardware/Sensor;", "sensorGyroscope", "sensorManager", "Landroid/hardware/SensorManager;", "sensorProximity", "shake", "sharedPrefs", "Landroid/content/SharedPreferences;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "checkSensor", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "onPause", "onResume", "openAllFurniture", "setUpToolbar", "app_debug"})
public final class DashboardActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    private androidx.coordinatorlayout.widget.CoordinatorLayout coordinatorLayout;
    private androidx.appcompat.widget.Toolbar toolbar;
    private android.widget.FrameLayout frameLayout;
    private com.google.android.material.navigation.NavigationView navigationView;
    private android.view.MenuItem previousMenuItem;
    private com.sabin.sastofurniture.Preferences preferences;
    private android.content.SharedPreferences sharedPrefs;
    private android.hardware.SensorManager sensorManager;
    private android.hardware.Sensor sensorAccelerometer;
    private android.hardware.Sensor sensorProximity;
    private android.hardware.Sensor sensorGyroscope;
    private float acclValue = 0.0F;
    private float lastAcclValue = 0.0F;
    private float shake = 0.0F;
    private android.os.PowerManager powerManager;
    private android.os.PowerManager.WakeLock wakeLock;
    private int field = 32;
    private final android.hardware.SensorEventListener accelerometerEventListener = null;
    private final android.hardware.SensorEventListener proximityEventListener = null;
    private final android.hardware.SensorEventListener gyroEventListener = null;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setUpToolbar() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final boolean checkSensor() {
        return false;
    }
    
    private final void openAllFurniture() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    public DashboardActivity() {
        super();
    }
}