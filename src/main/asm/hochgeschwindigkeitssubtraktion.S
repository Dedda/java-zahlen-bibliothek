.section .text
.global hochgeschwindigkeitssubtraktion
hochgeschwindigkeitssubtraktion:
    push %ebp
    mov %esp, %ebp
    mov 8(%ebp), %ecx
    mov 12(%ebp), %edx
    sub %ecx, %edx
    mov %edx, %eax
    mov %ebp, %esp
    pop %ebp
    ret