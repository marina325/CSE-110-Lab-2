package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two(){
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity->{
            var button_one = activity.findViewById(R.id.btn_one);
            var button_plus = activity.findViewById(R.id.btn_plus);
            var button_equals = activity.findViewById(R.id.btn_equals);
            android.widget.TextView display_view = activity.findViewById(R.id.display);

            button_one.performClick();
            button_plus.performClick();
            button_one.performClick();
            button_equals.performClick();

            assertEquals("2", display_view.getText()+"");
        });

    }
}
