package au.com.wallaceit.voicemail.activity.setup;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.fsck.k9.activity.setup.*;
import com.fsck.k9.activity.setup.AuthTypeHolder;
import com.fsck.k9.mail.AuthType;


class AuthTypeAdapter extends ArrayAdapter<com.fsck.k9.activity.setup.AuthTypeHolder> {
    public AuthTypeAdapter(Context context, int resource, com.fsck.k9.activity.setup.AuthTypeHolder[] holders) {
        super(context, resource, holders);
    }

    public static com.fsck.k9.activity.setup.AuthTypeAdapter get(Context context) {
        AuthType[] authTypes = new AuthType[]{AuthType.PLAIN, AuthType.CRAM_MD5, AuthType.EXTERNAL};
        com.fsck.k9.activity.setup.AuthTypeHolder[] holders = new com.fsck.k9.activity.setup.AuthTypeHolder[authTypes.length];
        for (int i = 0; i < authTypes.length; i++) {
            holders[i] = new com.fsck.k9.activity.setup.AuthTypeHolder(authTypes[i], context.getResources());
        }
        com.fsck.k9.activity.setup.AuthTypeAdapter authTypesAdapter = new com.fsck.k9.activity.setup.AuthTypeAdapter(context,
                android.R.layout.simple_spinner_item, holders);
        authTypesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return authTypesAdapter;
    }

    /**
     * Used to select an appropriate localized text label for the
     * {@code AuthType.PLAIN} option presented to users.
     *
     * @param insecure
     *            <p>
     *            A value of {@code true} will use "Normal password".
     *            <p>
     *            A value of {@code false} will use
     *            "Password, transmitted insecurely"
     */
    public void useInsecureText(boolean insecure) {
        for (int i=0; i<getCount(); i++) {
            getItem(i).setInsecure(insecure);
        }
        notifyDataSetChanged();
    }

    public int getAuthPosition(AuthType authenticationType) {
        for (int i=0; i<getCount(); i++) {
            if (getItem(i).authType == authenticationType) {
                return i;
            }
        }
        return -1;
    }
}