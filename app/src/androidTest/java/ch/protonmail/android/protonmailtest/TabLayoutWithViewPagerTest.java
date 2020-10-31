package ch.protonmail.android.protonmailtest;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

@RunWith(AndroidJUnit4.class)
public class TabLayoutWithViewPagerTest {
    private ViewPager pager;
    private TestPagerAdapter adapter;

    @Before
    public void setUp() throws Exception {
        pager = new ViewPager(InstrumentationRegistry.getTargetContext());
        adapter = new TestPagerAdapter();
    }
    @Test
    public void shouldSetAndGetAdapter() throws Exception {
        assertNull(pager.getAdapter());

        pager.setAdapter(adapter);
        assertSame(adapter, pager.getAdapter());
    }
    @Test
    public void test_getAndSetCurrentItem() throws Exception {
        pager.setCurrentItem(2);
        assertEquals(2, pager.getCurrentItem());
    }

    private static class TestPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return false;
        }
    }

}
