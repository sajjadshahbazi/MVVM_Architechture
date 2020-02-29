package com.example.mvvm_architechture.utils;

import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.airbnb.epoxy.EpoxyModel;

import org.jetbrains.annotations.NotNull;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

public abstract class EpoxyViewModel extends EpoxyModel {
    @Nullable
    private Function1 click;
    private View view;
    private final int layoutRes;

    @Nullable
    public final Function1 getClick() {
        return this.click;
    }

    public final void setClick(@Nullable Function1 var1) {
        this.click = var1;
    }

    @NotNull
    public final EpoxyViewModel setClickRet(@NotNull Function1 call) {
        Intrinsics.checkParameterIsNotNull(call, "call");
        this.click = call;
        return this;
    }

    public abstract void bindView(@NotNull View var1);

    public void bind(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.view = view;
        this.bindView(view);
        view.setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                Function1 var10000 = EpoxyViewModel.this.getClick();
                if (var10000 != null) {
                    Unit var2 = (Unit)var10000.invoke(EpoxyViewModel.this);
                }

            }
        }));
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void bind(Object var1) {
        this.bind((View)var1);
    }

    public void unbind(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        this.view = (View)null;
    }

    // $FF: synthetic method
    // $FF: bridge method
    public void unbind(Object var1) {
        this.unbind((View)var1);
    }

    public final void actions(@Nullable Function1 click) {
        this.click = click;
    }

    // $FF: synthetic method
    public static void actions$default(EpoxyViewModel var0, Function1 var1, int var2, Object var3) {
        if (var3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: actions");
        } else {
            if ((var2 & 1) != 0) {
                var1 = (Function1)null;
            }

            var0.actions(var1);
        }
    }

    protected int getDefaultLayout() {
        return this.layoutRes;
    }

    @NotNull
    protected final ReadOnlyProperty bind(@IdRes final int id) {
        return (ReadOnlyProperty)(new ReadOnlyProperty() {
            @NotNull
            public View getValue(@NotNull EpoxyViewModel thisRef, @NotNull KProperty property) throws Throwable {
                Intrinsics.checkParameterIsNotNull(thisRef, "thisRef");
                Intrinsics.checkParameterIsNotNull(property, "property");
                View var10000 = EpoxyViewModel.this.view;
                var10000 = var10000 != null ? var10000.findViewById(id) : null;
                if (var10000 != null) {
                    return var10000;
                } else {
                    throw (Throwable)(new IllegalStateException("View ID " + id + " for '" + property.getName() + "' not found."));
                }
            }

            // $FF: synthetic method
            // $FF: bridge method
            public Object getValue(Object var1, KProperty var2) {
                try {
                    return this.getValue((EpoxyViewModel)var1, var2);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                return null;
            }
        });
    }

    public EpoxyViewModel(@LayoutRes int layoutRes) {
        this.layoutRes = layoutRes;
    }

    // $FF: synthetic method
    public static final void access$setView$p(EpoxyViewModel $this, View var1) {
        $this.view = var1;
    }
}
