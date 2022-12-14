
…«
q
MainActivityTest2_12_12_22com.taskmastermdt.activitiesmainActivityTest2_12_12_222»Ò‰ú¿Ωö/:»Ò‰ú¿ﬂ Æº¿
É`androidx.test.espresso.NoMatchingViewException: No views in hierarchy found matching: (view.getId() is <2131230743/com.taskmastermdt:id/MainActivityBtnAddTask> and an instance of android.widget.TextView and view.getText() with or without transformation to match: is "ADD TASK" and Child at position 2 in parent Child at position 0 in parent view.getId() is <16908290/android:id/content> and (view has effective visibility <VISIBLE> and view.getGlobalVisibleRect() to return non-empty rectangle))

View Hierarchy:
+>DecorView{id=-1, visibility=VISIBLE, width=1080, height=2280, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params={(0,0)(fillxfill) ty=BASE_APPLICATION wanim=0x1030300
fl=LAYOUT_IN_SCREEN LAYOUT_INSET_DECOR SPLIT_TOUCH HARDWARE_ACCELERATED DRAWS_SYSTEM_BAR_BACKGROUNDS
pfl=NO_MOVE_ANIMATION FORCE_DRAW_STATUS_BAR_BACKGROUND FIT_INSETS_CONTROLLED
bhv=DEFAULT
fitSides=}, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=3}
|
+->LinearLayout{id=-1, visibility=VISIBLE, width=1080, height=2214, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2}
|
+-->ViewStub{id=16908741, res-name=action_mode_bar_stub, visibility=GONE, width=0, height=0, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=true, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0}
|
+-->FrameLayout{id=-1, visibility=VISIBLE, width=1080, height=2148, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=66.0, child-count=1}
|
+--->ActionBarOverlayLayout{id=2131230923, res-name=decor_content_parent, visibility=VISIBLE, width=1080, height=2148, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2}
|
+---->ContentFrameLayout{id=16908290, res-name=content, visibility=VISIBLE, width=1080, height=1994, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=154.0, child-count=1}
|
+----->ConstraintLayout{id=-1, visibility=VISIBLE, width=1080, height=1994, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=8}
|
+------>MaterialButton{id=2131230746, res-name=MainActivityBtnSignUp, visibility=VISIBLE, width=275, height=132, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=55.0, y=1818.0, text=Sign Up, input-type=0, ime-target=false, has-links=false, is-checked=false}
|
+------>MaterialButton{id=2131230744, res-name=MainActivityBtnAllTasks, visibility=VISIBLE, width=319, height=132, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=368.0, y=1818.0, text=ALL TASKS, input-type=0, ime-target=false, has-links=false, is-checked=false}
|
+------>MaterialTextView{id=2131230749, res-name=MainActivityTextViewMyTasks, visibility=VISIBLE, width=234, height=74, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=51.0, y=52.0, text=My Tasks, input-type=0, ime-target=false, has-links=false}
|
+------>MaterialButton{id=2131230743, res-name=MainActivityBtnAddTask, visibility=VISIBLE, width=300, height=132, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=725.0, y=1818.0, text=ADD TASK, input-type=0, ime-target=false, has-links=false, is-checked=false}
|
+------>AppCompatImageButton{id=2131230747, res-name=MainActivityImgBtnSettings, desc=Settings, visibility=VISIBLE, width=154, height=142, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=852.0, y=41.0}
|
+------>MaterialTextView{id=2131230750, res-name=MainActivityTextViewUsernameTasks, visibility=VISIBLE, width=277, height=53, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=80.0, y=200.0, text=Mathew's Tasks, input-type=0, ime-target=false, has-links=false}
|
+------>RecyclerView{id=2131230748, res-name=MainActivityRecyclerViewTaskList, visibility=VISIBLE, width=963, height=1100, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=77.0, y=286.0, child-count=0}
|
+------>MaterialButton{id=2131230745, res-name=MainActivityBtnSignIn, visibility=VISIBLE, width=275, height=132, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=55.0, y=1686.0, text=Sign In, input-type=0, ime-target=false, has-links=false, is-checked=false}
|
+---->ActionBarContainer{id=2131230824, res-name=action_bar_container, visibility=VISIBLE, width=1080, height=154, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2}
|
+----->Toolbar{id=2131230822, res-name=action_bar, visibility=VISIBLE, width=1080, height=154, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2}
|
+------>AppCompatTextView{id=-1, visibility=VISIBLE, width=416, height=74, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.Toolbar$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=44.0, y=40.0, text=TaskmasterMDT, input-type=0, ime-target=false, has-links=false}
|
+------>ActionMenuView{id=-1, visibility=VISIBLE, width=0, height=154, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.Toolbar$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=1080.0, y=0.0, child-count=0}
|
+----->ActionBarContextView{id=2131230830, res-name=action_context_bar, visibility=GONE, width=0, height=0, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=true, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=0}
|
+->View{id=16908336, res-name=navigationBarBackground, visibility=VISIBLE, width=1080, height=66, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=2214.0}
|
+->View{id=16908335, res-name=statusBarBackground, visibility=VISIBLE, width=1080, height=66, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0}
at androidx.test.espresso.NoMatchingViewException$Builder.build(NoMatchingViewException.java:5)
at androidx.test.espresso.base.DefaultFailureHandler.lambda$getNoMatchingViewExceptionTruncater$0(DefaultFailureHandler.java:5)
at androidx.test.espresso.base.DefaultFailureHandler$$ExternalSyntheticLambda1.truncateExceptionMessage(Unknown Source:2)
at androidx.test.espresso.base.ViewHierarchyExceptionHandler.handleSafely(ViewHierarchyExceptionHandler.java:5)
at androidx.test.espresso.base.ViewHierarchyExceptionHandler.handleSafely(ViewHierarchyExceptionHandler.java:1)
at androidx.test.espresso.base.DefaultFailureHandler$TypedFailureHandler.handle(DefaultFailureHandler.java:4)
at androidx.test.espresso.base.DefaultFailureHandler.handle(DefaultFailureHandler.java:5)
at androidx.test.espresso.ViewInteraction.waitForAndHandleInteractionResults(ViewInteraction.java:8)
at androidx.test.espresso.ViewInteraction.desugaredPerform(ViewInteraction.java:11)
at androidx.test.espresso.ViewInteraction.perform(ViewInteraction.java:8)
at com.taskmastermdt.activities.MainActivityTest2_12_12_22.mainActivityTest2_12_12_22(MainActivityTest2_12_12_22.java:56).androidx.test.espresso.NoMatchingViewExceptionÉ`androidx.test.espresso.NoMatchingViewException: No views in hierarchy found matching: (view.getId() is <2131230743/com.taskmastermdt:id/MainActivityBtnAddTask> and an instance of android.widget.TextView and view.getText() with or without transformation to match: is "ADD TASK" and Child at position 2 in parent Child at position 0 in parent view.getId() is <16908290/android:id/content> and (view has effective visibility <VISIBLE> and view.getGlobalVisibleRect() to return non-empty rectangle))

View Hierarchy:
+>DecorView{id=-1, visibility=VISIBLE, width=1080, height=2280, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params={(0,0)(fillxfill) ty=BASE_APPLICATION wanim=0x1030300
fl=LAYOUT_IN_SCREEN LAYOUT_INSET_DECOR SPLIT_TOUCH HARDWARE_ACCELERATED DRAWS_SYSTEM_BAR_BACKGROUNDS
pfl=NO_MOVE_ANIMATION FORCE_DRAW_STATUS_BAR_BACKGROUND FIT_INSETS_CONTROLLED
bhv=DEFAULT
fitSides=}, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=3}
|
+->LinearLayout{id=-1, visibility=VISIBLE, width=1080, height=2214, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2}
|
+-->ViewStub{id=16908741, res-name=action_mode_bar_stub, visibility=GONE, width=0, height=0, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=true, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0}
|
+-->FrameLayout{id=-1, visibility=VISIBLE, width=1080, height=2148, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=66.0, child-count=1}
|
+--->ActionBarOverlayLayout{id=2131230923, res-name=decor_content_parent, visibility=VISIBLE, width=1080, height=2148, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2}
|
+---->ContentFrameLayout{id=16908290, res-name=content, visibility=VISIBLE, width=1080, height=1994, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=154.0, child-count=1}
|
+----->ConstraintLayout{id=-1, visibility=VISIBLE, width=1080, height=1994, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=8}
|
+------>MaterialButton{id=2131230746, res-name=MainActivityBtnSignUp, visibility=VISIBLE, width=275, height=132, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=55.0, y=1818.0, text=Sign Up, input-type=0, ime-target=false, has-links=false, is-checked=false}
|
+------>MaterialButton{id=2131230744, res-name=MainActivityBtnAllTasks, visibility=VISIBLE, width=319, height=132, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=368.0, y=1818.0, text=ALL TASKS, input-type=0, ime-target=false, has-links=false, is-checked=false}
|
+------>MaterialTextView{id=2131230749, res-name=MainActivityTextViewMyTasks, visibility=VISIBLE, width=234, height=74, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=51.0, y=52.0, text=My Tasks, input-type=0, ime-target=false, has-links=false}
|
+------>MaterialButton{id=2131230743, res-name=MainActivityBtnAddTask, visibility=VISIBLE, width=300, height=132, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=725.0, y=1818.0, text=ADD TASK, input-type=0, ime-target=false, has-links=false, is-checked=false}
|
+------>AppCompatImageButton{id=2131230747, res-name=MainActivityImgBtnSettings, desc=Settings, visibility=VISIBLE, width=154, height=142, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=852.0, y=41.0}
|
+------>MaterialTextView{id=2131230750, res-name=MainActivityTextViewUsernameTasks, visibility=VISIBLE, width=277, height=53, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=80.0, y=200.0, text=Mathew's Tasks, input-type=0, ime-target=false, has-links=false}
|
+------>RecyclerView{id=2131230748, res-name=MainActivityRecyclerViewTaskList, visibility=VISIBLE, width=963, height=1100, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=77.0, y=286.0, child-count=0}
|
+------>MaterialButton{id=2131230745, res-name=MainActivityBtnSignIn, visibility=VISIBLE, width=275, height=132, has-focus=false, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=false, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=55.0, y=1686.0, text=Sign In, input-type=0, ime-target=false, has-links=false, is-checked=false}
|
+---->ActionBarContainer{id=2131230824, res-name=action_bar_container, visibility=VISIBLE, width=1080, height=154, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2}
|
+----->Toolbar{id=2131230822, res-name=action_bar, visibility=VISIBLE, width=1080, height=154, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2}
|
+------>AppCompatTextView{id=-1, visibility=VISIBLE, width=416, height=74, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.Toolbar$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=44.0, y=40.0, text=TaskmasterMDT, input-type=0, ime-target=false, has-links=false}
|
+------>ActionMenuView{id=-1, visibility=VISIBLE, width=0, height=154, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.Toolbar$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=1080.0, y=0.0, child-count=0}
|
+----->ActionBarContextView{id=2131230830, res-name=action_context_bar, visibility=GONE, width=0, height=0, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=true, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=0}
|
+->View{id=16908336, res-name=navigationBarBackground, visibility=VISIBLE, width=1080, height=66, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=2214.0}
|
+->View{id=16908335, res-name=statusBarBackground, visibility=VISIBLE, width=1080, height=66, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@YYYYYY, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0}
at androidx.test.espresso.NoMatchingViewException$Builder.build(NoMatchingViewException.java:5)
at androidx.test.espresso.base.DefaultFailureHandler.lambda$getNoMatchingViewExceptionTruncater$0(DefaultFailureHandler.java:5)
at androidx.test.espresso.base.DefaultFailureHandler$$ExternalSyntheticLambda1.truncateExceptionMessage(Unknown Source:2)
at androidx.test.espresso.base.ViewHierarchyExceptionHandler.handleSafely(ViewHierarchyExceptionHandler.java:5)
at androidx.test.espresso.base.ViewHierarchyExceptionHandler.handleSafely(ViewHierarchyExceptionHandler.java:1)
at androidx.test.espresso.base.DefaultFailureHandler$TypedFailureHandler.handle(DefaultFailureHandler.java:4)
at androidx.test.espresso.base.DefaultFailureHandler.handle(DefaultFailureHandler.java:5)
at androidx.test.espresso.ViewInteraction.waitForAndHandleInteractionResults(ViewInteraction.java:8)
at androidx.test.espresso.ViewInteraction.desugaredPerform(ViewInteraction.java:11)
at androidx.test.espresso.ViewInteraction.perform(ViewInteraction.java:8)
at com.taskmastermdt.activities.MainActivityTest2_12_12_22.mainActivityTest2_12_12_22(MainActivityTest2_12_12_22.java:56)"˘

logcatandroid„
‡/Users/mathewtorres/projects/courses/401/taskmaster-cloud/app/build/outputs/androidTest-results/connected/Pixel_4_API_33(AVD) - 13/logcat-com.taskmastermdt.activities.MainActivityTest2_12_12_22-mainActivityTest2_12_12_22.txt"Ø

device-infoandroidî
ë/Users/mathewtorres/projects/courses/401/taskmaster-cloud/app/build/outputs/androidTest-results/connected/Pixel_4_API_33(AVD) - 13/device-info.pb"∞

device-info.meminfoandroidç
ä/Users/mathewtorres/projects/courses/401/taskmaster-cloud/app/build/outputs/androidTest-results/connected/Pixel_4_API_33(AVD) - 13/meminfo"∞

device-info.cpuinfoandroidç
ä/Users/mathewtorres/projects/courses/401/taskmaster-cloud/app/build/outputs/androidTest-results/connected/Pixel_4_API_33(AVD) - 13/cpuinfo*î
c
test-results.logOcom.google.testing.platform.runtime.android.driver.AndroidInstrumentationDriverû
õ/Users/mathewtorres/projects/courses/401/taskmaster-cloud/app/build/outputs/androidTest-results/connected/Pixel_4_API_33(AVD) - 13/testlog/test-results.log 2
text/plain