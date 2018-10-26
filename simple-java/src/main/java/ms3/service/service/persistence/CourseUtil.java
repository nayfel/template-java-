package ms3.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ms3.service.model.Course;

import java.util.List;

/**
 * The persistence utility for the course service. This utility wraps {@link CoursePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jackt
 * @see CoursePersistence
 * @see CoursePersistenceImpl
 * @generated
 */
public class CourseUtil {
    private static CoursePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Course course) {
        getPersistence().clearCache(course);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Course> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Course update(Course course) throws SystemException {
        return getPersistence().update(course);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Course update(Course course, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(course, serviceContext);
    }

    /**
    * Returns the course where courseId = &#63; or throws a {@link ms3.service.NoSuchCourseException} if it could not be found.
    *
    * @param courseId the course ID
    * @return the matching course
    * @throws ms3.service.NoSuchCourseException if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Course findByCourseId(long courseId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException {
        return getPersistence().findByCourseId(courseId);
    }

    /**
    * Returns the course where courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param courseId the course ID
    * @return the matching course, or <code>null</code> if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Course fetchByCourseId(long courseId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCourseId(courseId);
    }

    /**
    * Returns the course where courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param courseId the course ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching course, or <code>null</code> if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Course fetchByCourseId(long courseId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByCourseId(courseId, retrieveFromCache);
    }

    /**
    * Removes the course where courseId = &#63; from the database.
    *
    * @param courseId the course ID
    * @return the course that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Course removeByCourseId(long courseId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException {
        return getPersistence().removeByCourseId(courseId);
    }

    /**
    * Returns the number of courses where courseId = &#63;.
    *
    * @param courseId the course ID
    * @return the number of matching courses
    * @throws SystemException if a system exception occurred
    */
    public static int countByCourseId(long courseId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCourseId(courseId);
    }

    /**
    * Returns the course where title = &#63; or throws a {@link ms3.service.NoSuchCourseException} if it could not be found.
    *
    * @param title the title
    * @return the matching course
    * @throws ms3.service.NoSuchCourseException if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Course findByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException {
        return getPersistence().findByTitle(title);
    }

    /**
    * Returns the course where title = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param title the title
    * @return the matching course, or <code>null</code> if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Course fetchByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTitle(title);
    }

    /**
    * Returns the course where title = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param title the title
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching course, or <code>null</code> if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Course fetchByTitle(
        java.lang.String title, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTitle(title, retrieveFromCache);
    }

    /**
    * Removes the course where title = &#63; from the database.
    *
    * @param title the title
    * @return the course that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Course removeByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException {
        return getPersistence().removeByTitle(title);
    }

    /**
    * Returns the number of courses where title = &#63;.
    *
    * @param title the title
    * @return the number of matching courses
    * @throws SystemException if a system exception occurred
    */
    public static int countByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTitle(title);
    }

    /**
    * Caches the course in the entity cache if it is enabled.
    *
    * @param course the course
    */
    public static void cacheResult(ms3.service.model.Course course) {
        getPersistence().cacheResult(course);
    }

    /**
    * Caches the courses in the entity cache if it is enabled.
    *
    * @param courses the courses
    */
    public static void cacheResult(
        java.util.List<ms3.service.model.Course> courses) {
        getPersistence().cacheResult(courses);
    }

    /**
    * Creates a new course with the primary key. Does not add the course to the database.
    *
    * @param title the primary key for the new course
    * @return the new course
    */
    public static ms3.service.model.Course create(java.lang.String title) {
        return getPersistence().create(title);
    }

    /**
    * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param title the primary key of the course
    * @return the course that was removed
    * @throws ms3.service.NoSuchCourseException if a course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Course remove(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException {
        return getPersistence().remove(title);
    }

    public static ms3.service.model.Course updateImpl(
        ms3.service.model.Course course)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(course);
    }

    /**
    * Returns the course with the primary key or throws a {@link ms3.service.NoSuchCourseException} if it could not be found.
    *
    * @param title the primary key of the course
    * @return the course
    * @throws ms3.service.NoSuchCourseException if a course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Course findByPrimaryKey(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException {
        return getPersistence().findByPrimaryKey(title);
    }

    /**
    * Returns the course with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param title the primary key of the course
    * @return the course, or <code>null</code> if a course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Course fetchByPrimaryKey(
        java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(title);
    }

    /**
    * Returns all the courses.
    *
    * @return the courses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ms3.service.model.Course> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the courses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of courses
    * @param end the upper bound of the range of courses (not inclusive)
    * @return the range of courses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ms3.service.model.Course> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the courses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of courses
    * @param end the upper bound of the range of courses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of courses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ms3.service.model.Course> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the courses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of courses.
    *
    * @return the number of courses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static CoursePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (CoursePersistence) PortletBeanLocatorUtil.locate(ms3.service.service.ClpSerializer.getServletContextName(),
                    CoursePersistence.class.getName());

            ReferenceRegistry.registerReference(CourseUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(CoursePersistence persistence) {
    }
}
