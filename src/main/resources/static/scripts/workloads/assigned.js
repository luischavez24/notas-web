let assignedModule = (function($) {

    const workloadTableId = "#workloadTable";

    function loadTableParameters() {
        $(workloadTableId).DataTable({
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
                    render({ classroom }) {
                        return `
                            <a href="/workloads/assigned/enrollments/${classroom.grade.gradeId}/${classroom.sectionId}" 
                                class="btn btn-info btn-circle">
                                <i class="fa fa-info"></i>
                            </a>
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
})(jQuery);

window.onload = assignedModule.main;