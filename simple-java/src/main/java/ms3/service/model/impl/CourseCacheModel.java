package ms3.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ms3.service.model.Course;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Course in entity cache.
 *
 * @author jackt
 * @see Course
 * @generated
 */
public class CourseCacheModel implements CacheModel<Course>, Externalizable {
    public String title;
    public String description;
    public String listPrice;
    public String provider;
    public long courseId;
    public double estimatedHours;
    public String sections;
    public String skills;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", listPrice=");
        sb.append(listPrice);
        sb.append(", provider=");
        sb.append(provider);
        sb.append(", courseId=");
        sb.append(courseId);
        sb.append(", estimatedHours=");
        sb.append(estimatedHours);
        sb.append(", sections=");
        sb.append(sections);
        sb.append(", skills=");
        sb.append(skills);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Course toEntityModel() {
        CourseImpl courseImpl = new CourseImpl();

        if (title == null) {
            courseImpl.setTitle(StringPool.BLANK);
        } else {
            courseImpl.setTitle(title);
        }

        if (description == null) {
            courseImpl.setDescription(StringPool.BLANK);
        } else {
            courseImpl.setDescription(description);
        }

        if (listPrice == null) {
            courseImpl.setListPrice(StringPool.BLANK);
        } else {
            courseImpl.setListPrice(listPrice);
        }

        if (provider == null) {
            courseImpl.setProvider(StringPool.BLANK);
        } else {
            courseImpl.setProvider(provider);
        }

        courseImpl.setCourseId(courseId);
        courseImpl.setEstimatedHours(estimatedHours);

        if (sections == null) {
            courseImpl.setSections(StringPool.BLANK);
        } else {
            courseImpl.setSections(sections);
        }

        if (skills == null) {
            courseImpl.setSkills(StringPool.BLANK);
        } else {
            courseImpl.setSkills(skills);
        }

        courseImpl.resetOriginalValues();

        return courseImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        listPrice = objectInput.readUTF();
        provider = objectInput.readUTF();
        courseId = objectInput.readLong();
        estimatedHours = objectInput.readDouble();
        sections = objectInput.readUTF();
        skills = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
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

        if (listPrice == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(listPrice);
        }

        if (provider == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(provider);
        }

        objectOutput.writeLong(courseId);
        objectOutput.writeDouble(estimatedHours);

        if (sections == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sections);
        }

        if (skills == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(skills);
        }
    }
}
