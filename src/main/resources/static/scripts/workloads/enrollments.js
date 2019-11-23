let enrollmentModule = (function($, gradeId, sectionId) {

    const enrollmentTableId = "#enrollmentsTable";

    function loadTableParameters() {
        $(enrollmentTableId).DataTable({
            serverSide: true,
            responsive: true,
            searching: false,
            pageLength: 20,
            lengthChange: false,
            sDom: 'Rlfrtip',
            columns: [
                { data: 'student', render: student => student.dni },
                { data: 'student', render: student => student.paternalSurname },
                { data: 'student', render: student => student.maternalSurname },
                { data: 'student', render: student => student.names },
                {
                    data: null,
                    render(workload) {
                        return ` `;
                    }
                },
            ],
            ajax: {
                method: 'GET',
                url: `/api/workloads/${gradeId}/${sectionId}/enrollments`,
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
        console.log("Main")
        loadTableParameters();
    }

    return { main }
});