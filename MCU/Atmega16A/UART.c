
#include <avr/io.h>
#include <util/delay.h>
#define fosc  16000000//Atmelga16A ���þ���1MHZ
#define baud 9600	 //������
/*  		�ַ�������� 		 */
void put_c(unsigned char c)
{	 
     while (!(UCSRA&(1<<UDRE)));
	 UDR=c;    
}

/*  		�ַ����뺯�� 		 */	
unsigned char get_c(void)
{
	 while(!(UCSRA& (1<<RXC)));
     return UDR;
}

/*			UART��ʼ��				*/	
void uart_init(void)
{
	 //OSCCAL=0xB7;
	 UCSRB=(1<<RXEN)|(1<<TXEN);//�����ͺͽ���
	 UBRRL=((fosc/16/baud) -1)%256;
	 UBRRH=((fosc/16/baud) -1)/256;
	 UCSRC=(1<<URSEL)|(1<<UCSZ1)|(1<<UCSZ0);//8λ����+1λSTOPλ
}
/*			RS232ͨ��main����		*/
int main(void)
{
 	uart_init();
	unsigned char i;

 	while(1)
    {
		
		i = get_c();
		if(i !=0)
		{
			put_c(i);
			//put_c(");
		}

		//_delay_ms(1000); //˯��1s
	}
}
