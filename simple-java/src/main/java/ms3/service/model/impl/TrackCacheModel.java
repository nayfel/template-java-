package ms3.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ms3.service.model.Track;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Track in entity cache.
 *
 * @author jackt
 * @see Track
 * @generated
 */
public class TrackCacheModel implements CacheModel<Track>, Externalizable {
    public long trackId;
    public String title;
    public String description;
    public String courseList;
    public String accreditation;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{trackId=");
        sb.append(trackId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", courseList=");
        sb.append(courseList);
        sb.append(", accreditation=");
        sb.append(accreditation);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Track toEntityModel() {
        TrackImpl trackImpl = new TrackImpl();

        trackImpl.setTrackId(trackId);

        if (title == null) {
            trackImpl.setTitle(StringPool.BLANK);
        } else {
            trackImpl.setTitle(title);
        }

        if (description == null) {
            trackImpl.setDescription(StringPool.BLANK);
        } else {
            trackImpl.setDescription(description);
        }

        if (courseList == null) {
            trackImpl.setCourseList(StringPool.BLANK);
        } else {
            trackImpl.setCourseList(courseList);
        }

        if (accreditation == null) {
            trackImpl.setAccreditation(StringPool.BLANK);
        } else {
            trackImpl.setAccreditation(accreditation);
        }

        trackImpl.resetOriginalValues();

        return trackImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        trackId = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        courseList = objectInput.readUTF();
        accreditation = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(trackId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (courseList == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(courseList);
        }

        if (accreditation == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(accreditation);
        }
    }
}
