let assignedModule = (function ($) {

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
          render({ classroom, workloadId }) {
            console.log({ classroom });
            const { grade: { gradeId }, sectionId } = classroom;
            return `
              <a href="/workloads/assigned/enrollments/${gradeId}/${sectionId}" 
                class="btn btn-info btn-circle">
                <i class="fa fa-info"></i>
              </a>
              <a href="/workloads/assigned/upload-notes/${workloadId}" 
                class="btn btn-success btn-circle">
                <i class="fa fa-upload"></i>
              </a>
            `;

            //upload-notes
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
        },
        error(xhr) {
          $('body').loading('toggle');
          const { error, message } = xhr.responseJSON;
          Swal.fire({
            icon: 'error',
            title: error,
            text: message
          })
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