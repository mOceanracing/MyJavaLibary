package helperClasses;

import javax.annotation.Nonnull;
import java.util.prefs.Preferences;

public class MyPreferenceLibary {
    private final Preferences preferences = Preferences.userNodeForPackage(this.getClass());

    /**
     * Load the Preferences from the registry.
     *
     * @param preferencKey key whose associated value is to be returned.
     * @param preferencDef the value to be returned in the event that this
     *                     preference node has no value associated with <tt>key</tt>.
     * @return the value associated with <tt>key</tt>, or <tt>def</tt>
     * if no value is associated with <tt>key</tt>, or the backing
     * store is inaccessible.
     */
    public String getStringFromPreferences(@Nonnull final String preferencKey, @Nonnull final String preferencDef) {
        return preferences.get(preferencKey, preferencDef);
    }

    /**
     * Save the value into the registry.
     *
     * @param preferencKey   key with which the specified value is to be associated.
     * @param preferencValue value to be associated with the specified key.
     */
    public void setStringToPreferences(@Nonnull final String preferencKey, @Nonnull final String preferencValue) {
        preferences.put(preferencKey, preferencValue);
    }
}
