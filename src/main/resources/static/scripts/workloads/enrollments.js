let enrollmentModule = (function($, gradeId, sectionId) {

    const enrollmentTableId = "#enrollmenTable";

    function loadTableParameters() {
        $(enrollmentTableId).DataTable({
            serverSide: true,
            responsive: true,
            searching: false,
            pageLength: 20,
            lengthChange: false,
            sDom: 'Rlfrtip',
            columns: [
                { data: 'workloadId' },
                { data: 'academicYear' },
                { data: 'course', render: course => course.name },
                { data: 'classroom', render: classroom => classroom.grade.name },
                { data: 'classroom', render: classroom => classroom.name },
                {
                    data: null,
                    render(workload) {
                        return `
                            <button class="btn btn-info btn-circle">
                                <i class="fa fa-info"></i>
                            </button>
                        `;
                    }
                },
            ],
            ajax: {
                method: 'GET',
                url: '/api/workloads',
                beforeSend() {
                    $('body').loading('toggle');
                },
                complete() {
                    $('body').loading('toggle');
                }
            }
        })
    }

    function main() {
        loadTableParameters();
    }

    return { main }
});

// window.onload = enrollmentModule(jQuery, gradeId, sectionId).main;