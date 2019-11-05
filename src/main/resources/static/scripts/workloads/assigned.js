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
                { data: 'workloadId' },
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