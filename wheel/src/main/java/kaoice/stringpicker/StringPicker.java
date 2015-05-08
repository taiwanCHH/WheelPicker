package kaoice.stringpicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class StringPicker extends LinearLayout {

    private Object mInstance;

    private Class<?> mClazz;

    private String[] mValues;

    private static final String PICKER_CLASS;

    static {
        PICKER_CLASS = "android.widget.NumberPicker";
    }

    public StringPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void setCurrent(final int current) {
        String methodName = "setValue";
        try {
            Method method = mClazz.getMethod(methodName, int.class);
            method.invoke(mInstance, current);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getCurrent() {
        String methodName = "getValue";
        try {
            Method method = mClazz.getMethod(methodName);
            return (Integer) method.invoke(mInstance);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getCurrentValue() {
        return mValues[getCurrent()];
    }

    private NumberPicker.OnValueChangeListener aa = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {


        }
    };

    public void setValues(String[] values) {
        mValues = values;

        try {
            mClazz.getMethod("setMaxValue", int.class).invoke(mInstance, values.length - 1);
            mClazz.getMethod("setMinValue", int.class).invoke(mInstance, 0);
            mClazz.getMethod("setDisplayedValues", String[].class).invoke(mInstance, new Object[]{values});
            mClazz.getMethod("setOnValueChangedListener", NumberPicker.OnValueChangeListener.class).invoke(mInstance, mChangedListener);
            mClazz.getMethod("invalidate").invoke(mInstance);
        } catch (final Exception e) {
            setValues(values);
        }

    }

    private NumberPicker.OnValueChangeListener mChangedListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            onChanged();
        }
    };
    private OnSelectChangedListener mOnSelectChangedListener;

    public interface OnSelectChangedListener {
        void onSelectChanged(String city);
    }

    public void setSelectChangedListener(OnSelectChangedListener callback) {
        mOnSelectChangedListener = callback;
    }

    private void onChanged() {
        if (mOnSelectChangedListener != null) {
            mOnSelectChangedListener.onSelectChanged(getCurrentValue());
        }
    }

    public void setValues(List<String> values) {
        mValues = values.toArray(new String[values.size()]);
        setValues(mValues);
    }

    private void init(final Context context, final AttributeSet attrs) {
        try {
            Class<?> clazz = context.getClassLoader().loadClass(PICKER_CLASS);
            Constructor<?> constructor = clazz.getConstructor(Context.class, AttributeSet.class);
            mInstance = constructor.newInstance(context, attrs);
            mClazz = mInstance.getClass();

            String methodName = "setDescendantFocusability";
            Method method = mClazz.getMethod(methodName, int.class);
            method.invoke(mInstance, NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
        addView((View) mInstance);
        setOrientation(VERTICAL);
    }


}