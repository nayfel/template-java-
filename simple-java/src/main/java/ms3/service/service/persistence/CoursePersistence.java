package ms3.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ms3.service.model.Course;

/**
 * The persistence interface for the course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jackt
 * @see CoursePersistenceImpl
 * @see CourseUtil
 * @generated
 */
public interface CoursePersistence extends BasePersistence<Course> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CourseUtil} to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the course where courseId = &#63; or throws a {@link ms3.service.NoSuchCourseException} if it could not be found.
    *
    * @param courseId the course ID
    * @return the matching course
    * @throws ms3.service.NoSuchCourseException if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.Course findByCourseId(long courseId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException;

    /**
    * Returns the course where courseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param courseId the course ID
    * @return the matching course, or <code>null</code> if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.Course fetchByCourseId(long courseId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the course where courseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param courseId the course ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching course, or <code>null</code> if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.Course fetchByCourseId(long courseId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the course where courseId = &#63; from the database.
    *
    * @param courseId the course ID
    * @return the course that was removed
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.Course removeByCourseId(long courseId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException;

    /**
    * Returns the number of courses where courseId = &#63;.
    *
    * @param courseId the course ID
    * @return the number of matching courses
    * @throws SystemException if a system exception occurred
    */
    public int countByCourseId(long courseId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the course where title = &#63; or throws a {@link ms3.service.NoSuchCourseException} if it could not be found.
    *
    * @param title the title
    * @return the matching course
    * @throws ms3.service.NoSuchCourseException if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.Course findByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException;

    /**
    * Returns the course where title = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param title the title
    * @return the matching course, or <code>null</code> if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.Course fetchByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the course where title = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param title the title
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching course, or <code>null</code> if a matching course could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.Course fetchByTitle(java.lang.String title,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the course where title = &#63; from the database.
    *
    * @param title the title
    * @return the course that was removed
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.Course removeByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException;

    /**
    * Returns the number of courses where title = &#63;.
    *
    * @param title the title
    * @return the number of matching courses
    * @throws SystemException if a system exception occurred
    */
    public int countByTitle(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the course in the entity cache if it is enabled.
    *
    * @param course the course
    */
    public void cacheResult(ms3.service.model.Course course);

    /**
    * Caches the courses in the entity cache if it is enabled.
    *
    * @param courses the courses
    */
    public void cacheResult(java.util.List<ms3.service.model.Course> courses);

    /**
    * Creates a new course with the primary key. Does not add the course to the database.
    *
    * @param title the primary key for the new course
    * @return the new course
    */
    public ms3.service.model.Course create(java.lang.String title);

    /**
    * Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param title the primary key of the course
    * @return the course that was removed
    * @throws ms3.service.NoSuchCourseException if a course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.Course remove(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException;

    public ms3.service.model.Course updateImpl(ms3.service.model.Course course)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the course with the primary key or throws a {@link ms3.service.NoSuchCourseException} if it could not be found.
    *
    * @param title the primary key of the course
    * @return the course
    * @throws ms3.service.NoSuchCourseException if a course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.Course findByPrimaryKey(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchCourseException;

    /**
    * Returns the course with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param title the primary key of the course
    * @return the course, or <code>null</code> if a course with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.Course fetchByPrimaryKey(java.lang.String title)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the courses.
    *
    * @return the courses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ms3.service.model.Course> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<ms3.service.model.Course> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<ms3.service.model.Course> findAll(int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the courses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of courses.
    *
    * @return the number of courses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
