package ms3.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ms3.service.service.http.CourseServiceSoap}.
 *
 * @author jackt
 * @see ms3.service.service.http.CourseServiceSoap
 * @generated
 */
public class CourseSoap implements Serializable {
    private String _title;
    private String _description;
    private String _listPrice;
    private String _provider;
    private long _courseId;
    private double _estimatedHours;
    private String _sections;
    private String _skills;

    public CourseSoap() {
    }

    public static CourseSoap toSoapModel(Course model) {
        CourseSoap soapModel = new CourseSoap();

        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setListPrice(model.getListPrice());
        soapModel.setProvider(model.getProvider());
        soapModel.setCourseId(model.getCourseId());
        soapModel.setEstimatedHours(model.getEstimatedHours());
        soapModel.setSections(model.getSections());
        soapModel.setSkills(model.getSkills());

        return soapModel;
    }

    public static CourseSoap[] toSoapModels(Course[] models) {
        CourseSoap[] soapModels = new CourseSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CourseSoap[][] toSoapModels(Course[][] models) {
        CourseSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CourseSoap[models.length][models[0].length];
        } else {
            soapModels = new CourseSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CourseSoap[] toSoapModels(List<Course> models) {
        List<CourseSoap> soapModels = new ArrayList<CourseSoap>(models.size());

        for (Course model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CourseSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _title;
    }

    public void setPrimaryKey(String pk) {
        setTitle(pk);
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getListPrice() {
        return _listPrice;
    }

    public void setListPrice(String listPrice) {
        _listPrice = listPrice;
    }

    public String getProvider() {
        return _provider;
    }

    public void setProvider(String provider) {
        _provider = provider;
    }

    public long getCourseId() {
        return _courseId;
    }

    public void setCourseId(long courseId) {
        _courseId = courseId;
    }

    public double getEstimatedHours() {
        return _estimatedHours;
    }

    public void setEstimatedHours(double estimatedHours) {
        _estimatedHours = estimatedHours;
    }

    public String getSections() {
        return _sections;
    }

    public void setSections(String sections) {
        _sections = sections;
    }

    public String getSkills() {
        return _skills;
    }

    public void setSkills(String skills) {
        _skills = skills;
    }
}
