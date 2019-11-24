let uploadNotesModule = (function ($, workloadId, gradeId, sectionId, _csrf_token, _csrf_param_name) {

  const notesTableId = "#notesTable";

  function loadTableParameters() {
    const dtUploadNotes = $(notesTableId).DataTable({
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
          render({ student }) {
            return ` 
                            <input id="${student.dni}-homework-note" class="form-control" type="number" min="0" max="20" />
                        `;
          }
        },
        {
          data: null,
          render({ student }) {
            return ` 
                            <input id="${student.dni}-participation-note" class="form-control" type="number" min="0" max="20" />
                        `;
          }
        },
        {
          data: null,
          render({ student }) {
            return ` 
                            <input id="${student.dni}-partial-note" class="form-control" type="number" min="0" max="20" />
                        `;
          }
        },
        {
          data: null,
          render({ student }) {
            return ` 
                            <input id="${student.dni}-final-note" class="form-control" type="number" min="0" max="20" />
                        `;
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

    return dtUploadNotes;
  }

  function main() {
    const dtUploadNotes = loadTableParameters();
    $("#btnUploadNotes").click(() => {
      const studentNotes = dtUploadNotes.rows()
        .data()
        .toArray()
        .map(({ student }) => ({
          dni: student.dni,
          homeworkNote: parseInt($(`#${student.dni}-homework-note`).val()) || 0,
          participationNote: parseInt($(`#${student.dni}-participation-note`).val()) || 0,
          partialNote: parseInt($(`#${student.dni}-partial-note`).val()) || 0,
          finalNote: parseInt($(`#${student.dni}-final-note`).val()) || 0,
        }));


      $.ajax({
        method: "POST",
        contentType: "application/json",
        url: `/api/workloads/upload-notes`,
        headers: { "X-CSRF-TOKEN": _csrf_token },
        data: JSON.stringify({
          workloadId,
          studentNotes
        }),
        success(data) {
          Swal.fire({
            icon: 'success',
            title: 'Notas registradas',
            text: 'Las notas fueron registradas correctamente',
            allowOutsideClick: false,
            allowEscapeKey: false
          }).then(() => {
            window.location.replace("/workloads/assigned");
          })
        },
        error(xhr) {
          console.log({ xhr });
        }
      })


    });
    $("[data-toggle='tooltip']").tooltip();
  }

  return { main }
});