package ms3.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ms3.service.service.http.AssignmentServiceSoap}.
 *
 * @author jackt
 * @see ms3.service.service.http.AssignmentServiceSoap
 * @generated
 */
public class AssignmentSoap implements Serializable {
    private long _assignmentId;
    private String _courses_title;
    private String _ms3employeedb_uid;
    private String _assignedDate;
    private String _startDate;
    private String _endDate;
    private String _status;
    private String _cost;
    private boolean _certification;
    private double _hoursSpent;
    private String _currentSection;
    private String _notes;
    private String _admin;

    public AssignmentSoap() {
    }

    public static AssignmentSoap toSoapModel(Assignment model) {
        AssignmentSoap soapModel = new AssignmentSoap();

        soapModel.setAssignmentId(model.getAssignmentId());
        soapModel.setCourses_title(model.getCourses_title());
        soapModel.setMs3employeedb_uid(model.getMs3employeedb_uid());
        soapModel.setAssignedDate(model.getAssignedDate());
        soapModel.setStartDate(model.getStartDate());
        soapModel.setEndDate(model.getEndDate());
        soapModel.setStatus(model.getStatus());
        soapModel.setCost(model.getCost());
        soapModel.setCertification(model.getCertification());
        soapModel.setHoursSpent(model.getHoursSpent());
        soapModel.setCurrentSection(model.getCurrentSection());
        soapModel.setNotes(model.getNotes());
        soapModel.setAdmin(model.getAdmin());

        return soapModel;
    }

    public static AssignmentSoap[] toSoapModels(Assignment[] models) {
        AssignmentSoap[] soapModels = new AssignmentSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static AssignmentSoap[][] toSoapModels(Assignment[][] models) {
        AssignmentSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new AssignmentSoap[models.length][models[0].length];
        } else {
            soapModels = new AssignmentSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static AssignmentSoap[] toSoapModels(List<Assignment> models) {
        List<AssignmentSoap> soapModels = new ArrayList<AssignmentSoap>(models.size());

        for (Assignment model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new AssignmentSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _assignmentId;
    }

    public void setPrimaryKey(long pk) {
        setAssignmentId(pk);
    }

    public long getAssignmentId() {
        return _assignmentId;
    }

    public void setAssignmentId(long assignmentId) {
        _assignmentId = assignmentId;
    }

    public String getCourses_title() {
        return _courses_title;
    }

    public void setCourses_title(String courses_title) {
        _courses_title = courses_title;
    }

    public String getMs3employeedb_uid() {
        return _ms3employeedb_uid;
    }

    public void setMs3employeedb_uid(String ms3employeedb_uid) {
        _ms3employeedb_uid = ms3employeedb_uid;
    }

    public String getAssignedDate() {
        return _assignedDate;
    }

    public void setAssignedDate(String assignedDate) {
        _assignedDate = assignedDate;
    }

    public String getStartDate() {
        return _startDate;
    }

    public void setStartDate(String startDate) {
        _startDate = startDate;
    }

    public String getEndDate() {
        return _endDate;
    }

    public void setEndDate(String endDate) {
        _endDate = endDate;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public String getCost() {
        return _cost;
    }

    public void setCost(String cost) {
        _cost = cost;
    }

    public boolean getCertification() {
        return _certification;
    }

    public boolean isCertification() {
        return _certification;
    }

    public void setCertification(boolean certification) {
        _certification = certification;
    }

    public double getHoursSpent() {
        return _hoursSpent;
    }

    public void setHoursSpent(double hoursSpent) {
        _hoursSpent = hoursSpent;
    }

    public String getCurrentSection() {
        return _currentSection;
    }

    public void setCurrentSection(String currentSection) {
        _currentSection = currentSection;
    }

    public String getNotes() {
        return _notes;
    }

    public void setNotes(String notes) {
        _notes = notes;
    }

    public String getAdmin() {
        return _admin;
    }

    public void setAdmin(String admin) {
        _admin = admin;
    }
}
